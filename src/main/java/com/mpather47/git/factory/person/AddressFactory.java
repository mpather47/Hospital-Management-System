package com.mpather47.git.factory.person;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.utility.Helper;

public class AddressFactory {
    public static Address addAddress(String address,int postalCode, Person details){
        String addressId = Helper.generateId();
        return new Address.Builder().setAddressId(addressId).setAddress(address).setPostcode(postalCode).setDetails(details).build();
    }


}
