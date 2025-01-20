package com.example.AnimalCare_API.animal;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private int id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "gender", nullable = false)
    private String gender;


    @Column(name = "country", nullable = false)
    private String country;


    @Column(name = "date", nullable = false)
    private LocalDate dateOfEntry;


    @Column(name = "type", nullable = false)
    private String type;


    @Column(name = "family", nullable = false)
    private String family;


    @Column(name = "image", nullable = false)
    private String imageUrl;

    public Animal(int id, String name, String gender, String country, LocalDate dateOfEntry, String type, String family, String imageUrl) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.country = country;
        this.dateOfEntry = dateOfEntry;
        this.type = type;
        this.family = family;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDate dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Animal () {}
}
