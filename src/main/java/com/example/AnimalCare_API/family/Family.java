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

    @OneToMany(mappedBy = "family")
    private List<Animal> animals;

  //  @OneToMany(mappedBy = "family", cascade = CascadeType.ALL, orphanRemoval = true)
    // private final List<Animal> animal = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

}
