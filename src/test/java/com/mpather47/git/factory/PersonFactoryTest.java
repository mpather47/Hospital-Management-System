package com.mpather47.git.factory;

import com.mpather47.git.entity.Person;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonFactoryTest {
    // Tests if the method returns a null value
    @Test
    public void createPerson() {
        Person person = PersonFactory.createPerson(13231,"Marcell","1998/08/21");
        Assert.assertTrue(person instanceof Person);
    }
}