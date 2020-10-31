//package com.mpather47.git.repository.person.impl.person;
//
//import com.mpather47.git.entity.person.Address;
//import com.mpather47.git.factory.person.AddressFactory;
//import com.mpather47.git.factory.person.PersonFactory;
//import com.mpather47.git.repository.person.AddressRepository;
//import com.mpather47.git.repository.person.impl.AddressRepositoryImpl;
//import com.mpather47.git.utility.Helper;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class AddressRepositoryImplTest {
//    @Autowired
//    private  AddressRepository repository ;
//    private static Address address = AddressFactory.addAddress("15 Address Street", 324243,PersonFactory.createPerson( "Marcelll Pather","1998/21/08"));
//
//
//    @Test
//    public void a_create(){
//        Address created = repository.save(address);
//        Assert.assertEquals(address.getAddressId(),created.getAddressId());
//        System.out.println("Created:" + created);
//    }
//
//    @Test
//    public void b_read(){
//        Address read = repository.findById(address.getAddressId()).orElseGet(null);
//        System.out.println("Read:" + read);
//    }
//
//    @Test
//    public void c_update()
//    {
//
//        Address updated = new Address.Builder().copy(address).setAddress("20 Address Street").setPostcode(1111111).build();
//        updated = repository.save(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//
//    public void e_delete(){
//        boolean deleted = repository.delete(address.getAddressId());
//        Assert.assertTrue(deleted);
//    }
//
//    @Test
//
//    public void d_getAll(){
//        System.out.println("Get all: " + repository.getAll());
//    }
//
//
//}