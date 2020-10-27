//package com.mpather47.git.repository.person.impl.person;
//
//import com.mpather47.git.entity.person.Contact;
//import com.mpather47.git.factory.person.ContactFactory;
//import com.mpather47.git.factory.person.PersonFactory;
//import com.mpather47.git.repository.person.ContactRepository;
//import com.mpather47.git.repository.person.impl.ContactRepositoryImpl;
//import com.mpather47.git.utility.Helper;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class ContactRepositoryImplTest {
//    @Autowired
//    private  ContactRepository repository;
//    private static Contact contact = ContactFactory.addContact(24234433,32434323,"email@email.com", PersonFactory.createPerson("Marcell Pather", "1998/08/21"));
//
//    @Test
//    public void a_create(){
//        Contact created = repository.create(contact);
//        Assert.assertEquals(contact.getDetails().getPersonId(),created.getDetails().getPersonId());
//        System.out.println("Created:" + created);
//    }
//
//    @Test
//    public void b_read(){
//        Contact read = repository.read(contact.getContactId());
//        System.out.println("Read:" + read);
//    }
//
//    @Test
//    public void c_update()
//    {
//
//        Contact updated = new Contact.Builder().copy(contact).setCellphoneNo(1111111).setHomePhone(35344).setEmail("gsgg").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void e_delete(){
//        boolean deleted = repository.delete(contact.getContactId());
//        Assert.assertTrue(deleted);
//    }
//
//    @Test
//    public void d_getAll(){
//        System.out.println("Get all: " + repository.getAll());
//    }
//
//
//}
