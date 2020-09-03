package com.mpather47.git.services.person.impl;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.factory.person.AddressFactory;
import com.mpather47.git.factory.person.ContactFactory;
import com.mpather47.git.factory.person.PersonFactory;
import com.mpather47.git.services.person.AddressService;
import com.mpather47.git.services.person.ContactService;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.assertEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactServiceImplTest {
    private static ContactService service = ContactServiceImpl.getService();
    private static Helper help = new Helper();
    private static Contact contact = ContactFactory.addContact(24234433,32434323,"email@email.com", PersonFactory.createPerson(help.generateId(),"Marcell Pather", "1998/08/21"));

    @Test
    public void d_testGetAll() {
        Set<Contact> address = service.getAll();
        assertEquals(1,address.size());
        System.out.println("All people: " + address);
    }
    @Test
    public void a_testCreate() {
        Contact created = service.create(contact);
        Assert.assertEquals(contact.getDetails().getPersonId(),created.getDetails().getPersonId());
        System.out.println("Created:" + created);
    }
    @Test
    public void b_testRead() {
        Contact read = service.read(contact.getDetails().getPersonId());
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
        boolean deleted = service.delete(contact.getDetails().getPersonId());
        Assert.assertTrue(deleted);
    }
}
