package com.example.AnimalCare_API.type;

import com.example.AnimalCare_API.animal.Animal;
import com.example.AnimalCare_API.family.Family;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table (name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String typeName;

    @ManyToOne
    @JoinColumn(name = "family", nullable = false)
    private Family family;

    public Type () {}

    public Type(long id, String typeName, Family family, List<Animal> animals) {
        this.id = id;
        this.typeName = typeName;
        this.family = family;
    }

    public long getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    public Family getFamily() {
        return family;
    }
}
