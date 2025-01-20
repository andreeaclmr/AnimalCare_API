package com.example.AnimalCare_API.animal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository <Animal, Long> {
}
