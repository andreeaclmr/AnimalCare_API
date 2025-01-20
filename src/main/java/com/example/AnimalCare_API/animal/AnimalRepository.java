package com.example.AnimalCare_API.animal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalRepository extends JpaRepository <Animal, Long> {
    Optional<Animal> findByName(String name);
}
