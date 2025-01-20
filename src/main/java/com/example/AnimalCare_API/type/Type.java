package com.example.AnimalCare_API.type;

import com.example.AnimalCare_API.animal.Animal;
import com.example.AnimalCare_API.family.Family;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String typeName;

    @ManyToOne
    @JoinColumn(name = "family", nullable = false)
    private Family family;

    public Type () {}

    public Type(int id, String typeName, Family family, List<Animal> animals) {
        this.id = id;
        this.typeName = typeName;
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
