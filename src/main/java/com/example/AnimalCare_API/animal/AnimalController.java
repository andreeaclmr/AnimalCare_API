package com.example.AnimalCare_API.animal;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/api/admin/animals")
public class AnimalController {

    private final static List<Animal> animalsDB = new ArrayList<>();

    public AnimalController() {



    }
}
