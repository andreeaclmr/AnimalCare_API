package com.example.AnimalCare_API.animal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/admin/animals")
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return this.animalRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalsByID(@PathVariable Long id) {
        Optional<Animal> optionalAnimal = animalRepository.findById(id);

        if (optionalAnimal.isPresent()) {
            return new ResponseEntity<>(optionalAnimal.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createAnimal (@RequestBody Animal animal) {
        Optional<Animal> optionalAnimal = animalRepository.findByName(animal.getName());

        if (optionalAnimal.isPresent()) return new ResponseEntity<>("The name already exists", HttpStatus.BAD_REQUEST);

        Animal savedAnimal = animalRepository.save(animal);
        return new ResponseEntity<>(savedAnimal, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public void deleteAnimalById(@PathVariable Long id) {
        animalRepository.deleteById(id);
    }


}
