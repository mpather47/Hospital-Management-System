package com.mpather47.git.repository.person.impl.person;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.factory.person.AddressFactory;
import com.mpather47.git.factory.person.PersonFactory;
import com.mpather47.git.repository.person.AddressRepository;
import com.mpather47.git.repository.person.impl.AddressRepositoryImpl;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressRepositoryImplTest {
    private static AddressRepository repository = AddressRepositoryImpl.getRepository();
    private static Helper help = new Helper();
    private static Address address = AddressFactory.addAddress("15 Address Street", 324243,PersonFactory.createPerson(help.generateId(), "Marcelll Pather","1998/21/08"));


    @Test
    public void a_create(){
        Address created = repository.create(address);
        Assert.assertEquals(address.getDetails().getPersonId(),created.getDetails().getPersonId());
        System.out.println("Created:" + created);
    }

    @Test
    public void b_read(){
        Address read = repository.read(address.getDetails().getPersonId());
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update()
    {
        Address updated = new Address.Builder().copy(address).setAddress("20 Address Street").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void d_delete(){
        boolean deleted = repository.delete(address.getDetails().getPersonId());
        Assert.assertTrue(deleted);
    }

    @Test
    public void e_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }


}