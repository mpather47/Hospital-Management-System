package com.mpather47.git.factory.person;

import com.mpather47.git.entity.person.Contact;

public class ContactFactory {
    public static Contact addContact(int cellphoneNo, int telephoneNo, String email){
        return new Contact.Builder().setCellphoneNo(cellphoneNo).setHomePhone(telephoneNo).setEmail(email).build();
    }




}
