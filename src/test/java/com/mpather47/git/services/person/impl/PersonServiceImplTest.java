package com.mpather47.git.services.person.impl;

import com.mpather47.git.entity.person.Person;
import com.mpather47.git.factory.person.PersonFactory;
import com.mpather47.git.services.person.PersonService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Set;

import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonServiceImplTest {
    @Autowired
    private PersonService service;
    private static Person person = PersonFactory.createPerson("Marcell Panther", "1998/08/21");

    @Test
    public void d_testGetAll() {
        Set<Person> person = service.getAll();
        assertEquals(1,person.size());
        System.out.println("All people: " + person);
    }
    @Test
    public void a_testCreate() {
        Person created = service.create(person);
        Assert.assertEquals(person.getPersonId(),created.getPersonId());
        System.out.println("Created:" + created);
    }
    @Test
    public void b_testRead() {
        Person read = service.read(person.getPersonId());
        System.out.println("Read:" + read);
    }
    @Test
    public void c_testUpdate() {
        Person updated = new Person.Builder().copy(person).setName("Marcell Pather").setDateOfBirth("1998").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }
    @Test
    public void e_testDelete() {
        boolean deleted = service.delete(person.getPersonId());
        Assert.assertTrue(deleted);
    }
}

