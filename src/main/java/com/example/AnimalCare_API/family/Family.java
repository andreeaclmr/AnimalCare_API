package com.example.AnimalCare_API.family;

import com.example.AnimalCare_API.animal.Animal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "families")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "family_name", nullable = false)
    private String familyName;


    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Animal> animal = new ArrayList<>();


    public Family () {}

    public Family(long id, String familyName) {
        this.id = id;
        this.familyName = familyName;
    }

    public Long getId() {
        return id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public List<Animal> getAnimal() {
        return animal;
    }
}
