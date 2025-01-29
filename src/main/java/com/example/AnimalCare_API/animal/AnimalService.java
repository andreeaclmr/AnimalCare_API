
package com.example.AnimalCare_API.animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.AnimalCare_API.family.Family;
import com.example.AnimalCare_API.family.FamilyRepository;
import com.example.AnimalCare_API.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AnimalService {

    private final AnimalRepository repository;
    private final FamilyRepository familyRepository;
    private final ImageService imageService;

    public AnimalService(AnimalRepository repository,
                         FamilyRepository familyRepository,
                         ImageService imageService) {
        this.repository = repository;
        this.familyRepository = familyRepository;
        this.imageService = imageService;
    }

    private static final Logger logger = LoggerFactory.getLogger(AnimalService.class);
    public void store(AnimalRequestDTO animalResponseDTO)
    {
        try {
            logger.info("Processing new animal request: {}", animalResponseDTO);

            String imageUrl = imageService.saveImage(animalResponseDTO.image());
            logger.info("Image saved at URL: {}", imageUrl);

        Animal newAnimal =  new Animal();
        newAnimal.setName(animalResponseDTO.name());
        newAnimal.setGender(animalResponseDTO.gender());
        newAnimal.setCountry(animalResponseDTO.country());
        newAnimal.setType(animalResponseDTO.type());
        newAnimal.setImageUrl(imageUrl);
        newAnimal.setDateOfEntry(animalResponseDTO.dateOfEntry());



            Family family = familyRepository.findById(animalResponseDTO.family())
                    .orElseThrow(() -> new IllegalArgumentException("Family with ID " + animalResponseDTO.family() + " not found."));
            newAnimal.setFamily(family);

            // Save the animal to the database
            repository.save(newAnimal);
        } catch (IOException e) {
            logger.error("Error saving animal: {}", e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }



    }


