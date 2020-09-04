package com.mpather47.git.services.person;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.services.IService;

import java.util.Set;

public interface AddressService extends IService<Address, String> {
    Set<Address> getAll();

    //unique business logic
}
