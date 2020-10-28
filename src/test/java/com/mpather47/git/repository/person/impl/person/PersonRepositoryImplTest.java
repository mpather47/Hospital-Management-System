//package com.mpather47.git.repository.person.impl.person;
//
//import com.mpather47.git.entity.person.Person;
//import com.mpather47.git.factory.person.PersonFactory;
//import com.mpather47.git.repository.person.PersonRepository;
//import com.mpather47.git.repository.person.impl.PersonRepositoryImpl;
//import com.mpather47.git.utility.Helper;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class PersonRepositoryImplTest {
//    @Autowired
//    private PersonRepository repository;
//    private static Person person = PersonFactory.createPerson("Marcell Panther", "1998/08/21");
//
//    @Test
//    public void a_create(){
//        Person created = repository.create(person);
//        Assert.assertEquals(person.getPersonId(),created.getPersonId());
//        System.out.println("Created:" + created);
//    }
//
//    @Test
//    public void b_read(){
//        Person read = repository.read(person.getPersonId());
//        System.out.println("Read:" + read);
//    }
//
//    @Test
//    public void c_update()
//    {
//
//        Person updated = new Person.Builder().copy(person).setName("Marcell Pather").setDateOfBirth("1998").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void e_delete(){
//        boolean deleted = repository.delete(person.getPersonId());
//        Assert.assertTrue(deleted);
//    }
//
//    @Test
//    public void d_getAll(){
//        System.out.println("Get all: " + repository.getAll());
//    }
//
//}
