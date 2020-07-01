package com.mpather47.git.factory;

import com.mpather47.git.entity.Address;
import com.mpather47.git.entity.Contact;

public class ContactFactory {
    public static Contact addPhoneNo(int cellphoneNo){
        return new Contact.Builder().setCellphoneNo(cellphoneNo).build();
    }

    public static Contact addhomePhone(int homePhone){
        return new Contact.Builder().setHomePhone(homePhone).build();
    }

    public static Contact addEmail(String email){
        return new Contact.Builder().setEmail(email).build();
    }


}
