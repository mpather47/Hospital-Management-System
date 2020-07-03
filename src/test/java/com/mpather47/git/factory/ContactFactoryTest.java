package com.mpather47.git.factory;

import com.mpather47.git.entity.Contact;
import com.mpather47.git.entity.Person;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactFactoryTest {
    // Tests if the method returns a value of 0
    @Test
    public void addPhoneNo() {
        Contact contact = ContactFactory.addPhoneNo(423487943);
        Assert.assertEquals(0, contact.getCellphoneNo());
    }
    // Tests if the method returns a value of 0
    @Test
    public void addhomePhone() {
        Contact contact = ContactFactory.addhomePhone(423487943);
        Assert.assertEquals(0, contact.getHomePhone());
    }
    // Tests if the method returns a null value
    @Test
    public void addEmail() {
        Contact contact = ContactFactory.addEmail("dude@gmail.com");
        Assert.assertEquals(null, contact.getEmail());
    }




}