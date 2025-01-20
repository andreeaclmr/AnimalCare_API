package com.example.AnimalCare_API.animal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/admin/animals")
public class AnimalController {

    @GetMapping

public String saludar() {
        return "Hola";
    }

   // @PostMapping("/admin/animals/create")



}
