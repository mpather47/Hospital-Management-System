package com.mpather47.git.factory.person;

import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.factory.person.ContactFactory;
import org.junit.Assert;
import org.junit.Test;

public class ContactFactoryTest {
    // Tests if the method returns a value
    @Test
    public void addPhoneNo() {
        Contact contact = ContactFactory.addContact(2342343,234242,"email@gmail.com");
        System.out.println(contact);
        Assert.assertNotNull(contact);
    }




}