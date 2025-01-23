package com.example.AnimalCare_API.animal;

import com.example.AnimalCare_API.family.Family;
import com.example.AnimalCare_API.family.FamilyRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private final AnimalRepository repository;
    private final FamilyRepository familyRepository;

    public AnimalService(AnimalRepository repository, FamilyRepository familyRepository) {
        this.repository = repository;
        this.familyRepository = familyRepository;
    }

    public void store(AnimalRequestDTO animalRequestDTO) {
        // crear animal
        Animal newAnimal =  new Animal();
        newAnimal.setName(animalRequestDTO.name());
        newAnimal.setGender(animalRequestDTO.gender());
        newAnimal.setCountry(animalRequestDTO.country());
        newAnimal.setType(animalRequestDTO.type());
        newAnimal.setImageUrl(animalRequestDTO.imageUrl());



        // recuperamos la familia
        Family family = familyRepository.findById(animalRequestDTO.family()).orElseThrow();
        // asignamos la familia
        newAnimal.setFamily(family);



        // añadir un animal en base de datos
        repository.save(newAnimal);

    }

}
