package com.mpather47.git.factory.person;

import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.entity.person.Person;

public class ContactFactory {
    public static Contact addContact(int cellphoneNo, int telephoneNo, String email, Person person){
        return new Contact.Builder().setCellphoneNo(cellphoneNo).setHomePhone(telephoneNo).setEmail(email).setDetails(person).build();
    }




}
