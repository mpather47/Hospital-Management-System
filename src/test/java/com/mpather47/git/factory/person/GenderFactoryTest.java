package com.mpather47.git.factory.person;

import com.mpather47.git.entity.person.Gender;
import com.mpather47.git.factory.person.GenderFactory;
import org.junit.Assert;
import org.junit.Test;

public class GenderFactoryTest {

    @Test
    public void createGender(){
        Gender gender1 = GenderFactory.createGender(1, "Male");
        Gender gender2 = GenderFactory.createGender(2, "Female");

        Assert.assertNotSame(gender1, gender2);
    }

}