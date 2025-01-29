package com.example.AnimalCare_API.animal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public record AnimalRequestDTO(

        @NotBlank(message = "Name field cannot be empty")
        String name,

        @NotNull(message = "Family ID cannot be null")
        Long family,

        @NotBlank(message = "Gender field cannot be empty")
        String gender,

        @NotBlank(message = "Country field cannot be empty")
        String country,

        @NotNull(message = "Date of entry cannot be null")
        LocalDate dateOfEntry,

        @NotBlank(message = "Type field cannot be empty")
        String type,

        MultipartFile image

){}