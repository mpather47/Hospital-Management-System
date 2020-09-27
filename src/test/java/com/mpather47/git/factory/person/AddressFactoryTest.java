package com.mpather47.git.factory.person;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.Test;

public class AddressFactoryTest {
    // Tests if the method returns a value
    @Test
    public  void addAddress() {

        Address address = AddressFactory.addAddress("492094",23423, PersonFactory.createPerson("Marcell","1998/08/21"));
        System.out.println(address);
        Assert.assertNotNull(address);
    }



}