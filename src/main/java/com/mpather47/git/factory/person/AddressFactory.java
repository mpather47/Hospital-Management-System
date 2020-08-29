package com.mpather47.git.factory.person;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Person;

public class AddressFactory {
    public static Address addAddress(String address,int postalCode, Person details){
        return new Address.Builder().setAddress(address).setPostcode(postalCode).setDetails(details).build();
    }


}
