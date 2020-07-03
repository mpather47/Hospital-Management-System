package com.mpather47.git.factory;

import com.mpather47.git.entity.Address;
import com.mpather47.git.entity.Person;

public class AddressFactory {
    public static Address addAddress(String address){
        return new Address.Builder().setAddress(address).build();
    }

    public static Address addPostalCode(int postalCode){
        return new Address.Builder().setPostcode(postalCode).build();
    }
}
