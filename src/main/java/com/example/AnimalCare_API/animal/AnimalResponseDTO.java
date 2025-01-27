package com.example.AnimalCare_API.animal;


import java.time.LocalDate;

public record AnimalResponseDTO(
        String name,
        Long family,
        String gender,
        String country,
        LocalDate dateOfEntry,
        String type,
        String imageUrl

) {}
