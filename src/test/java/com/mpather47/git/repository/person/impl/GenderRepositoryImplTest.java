package com.mpather47.git.repository.person.impl;

import com.mpather47.git.entity.person.Gender;
import com.mpather47.git.factory.person.GenderFactory;
import com.mpather47.git.repository.person.GenderRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderRepositoryImplTest {

    private static GenderRepository repository = GenderRepositoryImpl.getGenderRepository();

    private static Gender gender = GenderFactory.createGender(1, "Male");

    @Test
    public void a_create() {
        Gender created = repository.create(gender);
        assertEquals(gender.getGenderId(), created.getGenderId());
    }

    @Test
    public void b_read() {
        Gender read = repository.read(gender.getGenderId());
        assertEquals(gender.getGenderId(), read.getGenderId());
    }

    @Test
    public void c_update() {
        Gender updated = new Gender.GenderBuilder().copy(gender).
                setGenderType("Female").build();

        updated = repository.update(updated);
        assertEquals(gender.getGenderId(), updated.getGenderId());
    }

    @Test
    public void e_delete() {
        repository.delete(gender.getGenderId());
        assertNull(repository.read(gender.getGenderId()));
    }

    @Test
    public void d_getAll() {
        Set<Gender> genders = repository.getAll();
        assertEquals(1, genders.size());
    }
}
