package com.mpather47.git.services.person.impl;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.factory.person.AddressFactory;
import com.mpather47.git.factory.person.PersonFactory;
import com.mpather47.git.services.person.AddressService;
import com.mpather47.git.services.person.PersonService;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressServiceImplTest {
    private static AddressService service = AddressServiceImpl.getService();
    private static Helper help = new Helper();
    private static Address address = AddressFactory.addAddress("15 Address Street", 324243,PersonFactory.createPerson(help.generateId(), "Marcelll Pather","1998/21/08"));

    @Test
    public void d_testGetAll() {
        Set<Address> address = service.getAll();
        assertEquals(1,address.size());
        System.out.println("All people: " + address);
    }
    @Test
    public void a_testCreate() {
        Address created = service.create(address);
        Assert.assertEquals(address.getDetails().getPersonId(),created.getDetails().getPersonId());
        System.out.println("Created:" + created);
    }
    @Test
    public void b_testRead() {
        Address read = service.read(address.getDetails().getPersonId());
        System.out.println("Read:" + read);
    }
    @Test
    public void c_testUpdate() {
        Address updated = new Address.Builder().copy(address).setAddress("20 Address Street").setPostcode(11111).build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }
    @Test
    public void e_testDelete() {
        boolean deleted = service.delete(address.getDetails().getPersonId());
        Assert.assertTrue(deleted);
    }
}

