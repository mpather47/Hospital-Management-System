package com.mpather47.git.repository.person.impl.person;

import com.mpather47.git.entity.person.Gender;
import com.mpather47.git.factory.person.GenderFactory;
import com.mpather47.git.repository.person.GenderRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderRepositoryImplTest {

    @Autowired
    private static GenderRepository repository;

    private static Gender gender = GenderFactory.createGender(1, "Male");

    @Test
    public void a_create() {
        Gender created = repository.save(gender);
        assertEquals(gender.getGenderId(), created.getGenderId());
    }

    @Test
    public void b_read() {
        Optional<Gender> read =  repository.findById(gender.getGenderId());
        assertEquals(gender.getGenderId(), read.orElse(null).getGenderId());
    }

    @Test
    public void c_update() {
        Gender updated = new Gender.GenderBuilder().copy(gender).
                setGenderType("Female").build();

        updated = repository.save(updated);
        assertEquals(gender.getGenderId(), updated.getGenderId());
    }

    @Test
    public void e_delete() {
        repository.deleteById(gender.getGenderId());
        Optional<Gender> read =  repository.findById(gender.getGenderId());
        assertNotEquals(gender.getGenderId(), read.orElse(null).getGenderId());
    }

    @Test
    public void d_getAll() {
        List<Gender> genders = repository.findAll();
        assertEquals(1, genders.size());
    }
}
