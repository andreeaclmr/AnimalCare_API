package com.example.AnimalCare_API.family;

import com.example.AnimalCare_API.type.Type;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "families")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "family_Name", nullable = false)
    private String familyName;


    public Family () {}

    public Family(int id, String familyName, List<Type> types) {
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
}
