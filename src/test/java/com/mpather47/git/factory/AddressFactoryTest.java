package com.mpather47.git.factory;

import com.mpather47.git.entity.Address;
import com.mpather47.git.entity.Person;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressFactoryTest {
    // Tests if the method returns a null value
    @Test
    public void addAddress() {
        Address address = AddressFactory.addAddress("Test case");
        Assert.assertEquals(null, address.getAddress());
    }
    // Tests if the method returns a null value
    @Test
    public void addPostalCode() {
            Address address = AddressFactory.addPostalCode("Test case");
            Assert.assertEquals(null, address.getPostcode());
    }


}