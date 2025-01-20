package com.example.AnimalCare_API.family;

import jakarta.persistence.*;

@Entity
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private int id;

    @Column(name = "familyName", nullable = false)
    private String familyName;

    public Family(int id, String familyName) {
        this.id = id;
        this.familyName = familyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Family () {

    }
}
