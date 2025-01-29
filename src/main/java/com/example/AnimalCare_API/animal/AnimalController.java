package com.example.AnimalCare_API.animal;
import com.example.AnimalCare_API.family.Family;
import com.example.AnimalCare_API.family.FamilyRepository;
import com.example.AnimalCare_API.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/admin/animals")
public class AnimalController {

    private static final Logger logger = LoggerFactory.getLogger(AnimalController.class);
    private final AnimalRepository animalRepository;
    private final AnimalService animalService;
    private final ImageService imageService;
    private final FamilyRepository familyRepository;


    @Autowired
        public AnimalController(AnimalRepository animalRepository,
                                AnimalService animalService,
                                ImageService imageService,
                                FamilyRepository familyRepository) {
            this.animalRepository = animalRepository;
            this.animalService = animalService;
            this.imageService = imageService;
            this.familyRepository = familyRepository;
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
    public ResponseEntity<List<Animal>> getAnimalsByFamily(
            @RequestParam Long familyId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            logger.info("Fetching animals for family ID: {}", familyId);

            Page<Animal> animalsPage = animalRepository.findByFamily_Id(familyId, PageRequest.of(page, size));
            List<Animal> animals = animalsPage.getContent();

            return ResponseEntity.ok(animals);
        } catch (Exception e) {
            logger.error("Failed to fetch animals by family: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    // Get animals by country without pagination
    @GetMapping("/country")
    public ResponseEntity<List<Animal>> getAnimalsByCountry(@RequestParam String country) {
        List<Animal> animals = animalRepository.findByCountry(country);
        return ResponseEntity.ok(animals);
    }

    // Get animals by family and type
    @GetMapping("/family-type")
    public ResponseEntity<List<Animal>> getAnimalsByFamilyAndType(
            @RequestParam Long familyId,
            @RequestParam String type) {
        List<Animal> animals = animalRepository.findByFamily_IdAndType(familyId, type);
        return ResponseEntity.ok(animals);
    }



   /* @PostMapping(value = "/post", consumes = "multipart/form-data")
    public ResponseEntity<Animal> createAnimal(@ModelAttribute AnimalRequestDTO animalRequestDTO) {
        try {
            String imageUrl = imageService.saveImage(animalRequestDTO.image());
            Animal animal = new Animal();
            animal.setName(animalRequestDTO.name());
            animal.setGender(animalRequestDTO.gender());
            animal.setCountry(animalRequestDTO.country());
            animal.setDateOfEntry(animalRequestDTO.dateOfEntry());
            animal.setType(animalRequestDTO.type());
            animal.setImageUrl(imageUrl);

            Family family = familyRepository.findById(animalRequestDTO.family())
                    .orElseThrow(() -> new IllegalArgumentException("Family not found"));
            animal.setFamily(family);

            Animal savedAnimal = animalRepository.save(animal);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAnimal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
*/

    @PostMapping(value = "/post", consumes = "multipart/form-data")
    public ResponseEntity<Animal> createAnimal(@ModelAttribute AnimalRequestDTO animalRequestDTO) {
        try {
            logger.info("Received POST request for animal: {}", animalRequestDTO);
            animalService.store(animalRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            logger.error("Failed to create animal: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


            @DeleteMapping("/del/animal/{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable long id) {
        animalRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/put/animal/{id}", consumes = "multipart/form-data")
    public ResponseEntity<Animal> updateAnimal(@PathVariable long id, @ModelAttribute AnimalRequestDTO animalRequestDTO) {
        try {
            logger.info("Received PUT request to update animal with id: {}", id);
            Optional<Animal> existingAnimalOpt = animalRepository.findById(id);

            if (existingAnimalOpt.isPresent()) {
                Animal updatedAnimal = existingAnimalOpt.get();

                if (animalRequestDTO.name() != null) updatedAnimal.setName(animalRequestDTO.name());
                if (animalRequestDTO.gender() != null) updatedAnimal.setGender(animalRequestDTO.gender());
                if (animalRequestDTO.country() != null) updatedAnimal.setCountry(animalRequestDTO.country());
                if (animalRequestDTO.dateOfEntry() != null) updatedAnimal.setDateOfEntry(animalRequestDTO.dateOfEntry());
                if (animalRequestDTO.type() != null) updatedAnimal.setType(animalRequestDTO.type());

                if (animalRequestDTO.family() != null) {
                    Family family = familyRepository.findById(animalRequestDTO.family())
                            .orElseThrow(() -> new IllegalArgumentException("Family not found"));
                    updatedAnimal.setFamily(family);
                }

                if (animalRequestDTO.image() != null && !animalRequestDTO.image().isEmpty()) {
                    String imageUrl = imageService.saveImage(animalRequestDTO.image());
                    updatedAnimal.setImageUrl(imageUrl);
                }

                Animal savedAnimal = animalRepository.save(updatedAnimal);
                logger.info("Successfully updated animal with id: {}", id);
                return ResponseEntity.ok(savedAnimal);
            } else {
                logger.warn("Animal with id {} not found", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            logger.error("Failed to update animal: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}