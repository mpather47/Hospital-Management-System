package com.mpather47.git.factory.person;

import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.factory.person.ContactFactory;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.Test;

public class ContactFactoryTest {
    // Tests if the method returns a value
    @Test
    public void addPhoneNo() {
        Helper helper = new Helper();
        Contact contact = ContactFactory.addContact(2342343,234242,"email@gmail.com", PersonFactory.createPerson(helper.generateId(),"Marcell Pather", "1998/08/21"));
        System.out.println(contact);
        Assert.assertNotNull(contact);
    }




}