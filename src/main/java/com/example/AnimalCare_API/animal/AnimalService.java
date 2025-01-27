
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

    public void store(AnimalRequestDTO animalResponseDTO) {
        // crear animal
        Animal newAnimal =  new Animal();
        newAnimal.setName(animalResponseDTO.name());
        newAnimal.setGender(animalResponseDTO.gender());
        newAnimal.setCountry(animalResponseDTO.country());
        newAnimal.setType(animalResponseDTO.type());
        newAnimal.setImageUrl(animalResponseDTO.imageUrl());
        newAnimal.setDateOfEntry(animalResponseDTO.dateOfEntry());


        // recuperamos la familia
        Family family = familyRepository.findById(animalResponseDTO.family())
                .orElseThrow(() -> new IllegalArgumentException("Family with ID " + animalResponseDTO.family() + " not found."));
        // asignamos la familia
        newAnimal.setFamily(family);



        // añadir un animal en base de datos
        repository.save(newAnimal);

    }

}
