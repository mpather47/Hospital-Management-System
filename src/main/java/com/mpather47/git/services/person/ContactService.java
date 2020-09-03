package com.mpather47.git.services.person;

import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.services.IService;

import java.util.Set;

public interface  ContactService extends IService<Contact, String> {
    Set<Contact> getAll();

    //unique business logic
}
