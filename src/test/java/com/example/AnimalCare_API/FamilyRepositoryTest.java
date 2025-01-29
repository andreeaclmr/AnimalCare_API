package com.example.AnimalCare_API;

import com.example.AnimalCare_API.family.Family;
import com.example.AnimalCare_API.family.FamilyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FamilyRepositoryTest {

    @Autowired
    private FamilyRepository familyRepository;

    @Test
    void testFindById() {
        Family family = new Family();
        family.setFamilyName("Test Family");
        Family savedFamily = familyRepository.save(family);

        assertThat(familyRepository.findById(savedFamily.getId())).isPresent();
    }
}
