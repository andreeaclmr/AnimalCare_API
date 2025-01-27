package com.example.AnimalCare_API.animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/admin/animals")
public class AnimalController {

        private final AnimalRepository animalRepository;
        private final AnimalService animalService;

        @Autowired
        public AnimalController(AnimalRepository animalRepository, AnimalService animalService) {
            this.animalRepository = animalRepository;
            this.animalService = animalService;
        }

    // Get all animals with pagination (max 20 animals per page)
    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        List<Animal> animals = animalRepository.findAll(PageRequest.of(page, size)).getContent();
        return ResponseEntity.ok(animals);
    }

    // Get animals by family with pagination (max 10 animals per page)
    @GetMapping("/family")
    public ResponseEntity<String> getAnimalsByFamily(
            @RequestParam Long familyId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            // Validate familyId
            if (familyId == null) {
                return ResponseEntity.badRequest().body(List.of().toString());
            }

            Page<Animal> animalsPage = (Page<Animal>) animalRepository.findByFamily_Id(familyId, PageRequest.of(page, size));
            List<Animal> animals = animalsPage.getContent();
            return ResponseEntity.ok(animals.toString());
        } catch (Exception e) {
            // Handle unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(List.of().toString());
        }
    }


    @PostMapping("/post")
    public ResponseEntity<String> createAnimal(@RequestBody AnimalRequestDTO animalRequestDTO) {
        try {
            animalService.store(animalRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Animal created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create animal: " + e.getMessage());
        }
    }


    @DeleteMapping("/del/animal/{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable long id) {
        animalRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping("/put/animal/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable long id, @RequestBody Animal animal) {
        try {
            Optional<Animal> existingAnimal = animalRepository.findById(id);
            if (existingAnimal.isPresent()) {
                Animal updatedAnimal = existingAnimal.get();
                updatedAnimal.setName(animal.getName());
                updatedAnimal.setGender(animal.getGender());
                updatedAnimal.setCountry(animal.getCountry());
                updatedAnimal.setDateOfEntry(animal.getDateOfEntry());
                updatedAnimal.setType(animal.getType());
                updatedAnimal.setFamily(animal.getFamily());
                updatedAnimal.setImageUrl(animal.getImageUrl());

                Animal savedAnimal = animalRepository.save(updatedAnimal);
                return ResponseEntity.ok(savedAnimal);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}