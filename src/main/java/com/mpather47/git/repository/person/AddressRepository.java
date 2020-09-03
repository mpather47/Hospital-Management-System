package com.mpather47.git.repository.person;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.repository.IRepository;

import java.util.Set;

public interface AddressRepository extends IRepository<Address,String> {
    Set<Address> getAll();
}
