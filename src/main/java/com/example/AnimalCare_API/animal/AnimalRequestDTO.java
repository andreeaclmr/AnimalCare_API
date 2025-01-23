package com.example.AnimalCare_API.animal;


import java.time.LocalDate;

public record AnimalRequestDTO(
        String name,
        Long family,
        String gender,
        String country,
        String type,
        String imageUrl

) {}
