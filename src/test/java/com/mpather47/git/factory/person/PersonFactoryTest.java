package com.mpather47.git.factory.person;

import com.mpather47.git.entity.person.Person;
import com.mpather47.git.factory.person.PersonFactory;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.Test;

public class PersonFactoryTest {
    // Tests if the method returns a value
    @Test
    public void createPerson() {

        Person person = PersonFactory.createPerson("Marcell","1998/08/21");
        System.out.println(person);
        Assert.assertNotNull(person);
    }
}