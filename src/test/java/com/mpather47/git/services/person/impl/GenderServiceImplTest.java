package com.mpather47.git.services.person.impl;

import com.mpather47.git.entity.person.Gender;
import com.mpather47.git.factory.person.GenderFactory;
import com.mpather47.git.services.person.GenderService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GenderServiceImplTest {

    private static GenderService service = GenderServiceImpl.getService();
    private static Gender gender = GenderFactory.createGender(1, "Male");

    @Test
    public void a_create() {
        Gender created = service.create(gender);
        assertEquals(gender.getGenderId(), created.getGenderId());
    }

    @Test
    public void b_read() {
        Gender read = service.read(gender.getGenderId());
        assertEquals(gender.getGenderId(), read.getGenderId());
    }

    @Test
    public void c_update() {
        Gender updated = new Gender.GenderBuilder().copy(gender).
                setGenderType("Female").build();

        updated = service.update(updated);
        assertEquals(gender.getGenderId(), updated.getGenderId());
    }

    @Test
    public void e_delete() {
        service.delete(gender.getGenderId());
        assertNull(service.read(gender.getGenderId()));
    }

    @Test
    public void d_getAll() {
        Set<Gender> genders = service.getAll();
        assertEquals(1, genders.size());
    }

}
