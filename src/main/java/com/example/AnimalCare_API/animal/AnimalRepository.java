package com.example.AnimalCare_API.animal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.net.ContentHandler;
import java.util.Optional;

public interface AnimalRepository extends JpaRepository <Animal, Long> {
    Optional<Animal> findByName(String name);

    ContentHandler findByFamily_Id(Long familyId, PageRequest of);
    Page<Animal> findByFamily_Id(Long familyId, Pageable pageable);
}
