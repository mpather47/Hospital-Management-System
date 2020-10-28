package com.mpather47.git.services.person.impl;


import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.factory.person.ContactFactory;
import com.mpather47.git.factory.person.PersonFactory;
import com.mpather47.git.services.person.ContactService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactServiceImplTest {
    @Autowired
    private ContactService service;
    private static Contact contact = ContactFactory.addContact(24234433,32434323,"email@email.com", PersonFactory.createPerson("Marcell Pather", "1998/08/21"));

    @Test
    public void d_testGetAll() {
        Set<Contact> address = service.getAll();
        assertEquals(1,address.size());
        System.out.println("All people: " + address);
    }
    @Test
    public void a_testCreate() {
        Contact created = service.create(contact);
        Assert.assertEquals(contact.getContactId(),created.getContactId());
        System.out.println("Created:" + created);
    }
    @Test
    public void b_testRead() {
        Contact read = service.read(contact.getContactId());
        System.out.println("Read:" + read);
    }
    @Test
    public void c_testUpdate() {
        Contact updated = new Contact.Builder().copy(contact).setCellphoneNo(1111111).setHomePhone(35344).setEmail("gsgg").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }
    @Test
    public void e_testDelete() {
        boolean deleted = service.delete(contact.getContactId());
        Assert.assertTrue(deleted);
    }
}
