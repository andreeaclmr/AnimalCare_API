package com.example.AnimalCare_API.animal;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
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
    private String countryOfOrigin;

    @Column(name = "date", nullable = false)
    private LocalDate dateOfEntry;

    @Column(name = "image", nullable = false)
    private String imageUrl;

    public Animal(int id, String name, String gender, String countryOfOrigin, LocalDate dateOfEntry, String imageUrl) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.countryOfOrigin = countryOfOrigin;
        this.dateOfEntry = dateOfEntry;
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

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDate dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Animal() {

    }
}
