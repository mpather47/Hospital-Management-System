package com.mpather47.git.factory.person;

import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.utility.Helper;

public class ContactFactory {
    public static Contact addContact(int cellphoneNo, int telephoneNo, String email, Person person){
        String contactId = Helper.generateId();
        return new Contact.Builder().setContactId(contactId).setCellphoneNo(cellphoneNo).setHomePhone(telephoneNo).setEmail(email).setDetails(person).build();
    }



}
