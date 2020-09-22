package com.mpather47.git.controller.person;

import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.factory.person.ContactFactory;
import com.mpather47.git.factory.person.PersonFactory;
import com.mpather47.git.services.person.impl.AddressServiceImpl;
import com.mpather47.git.services.person.impl.ContactServiceImpl;
import com.mpather47.git.services.person.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactServiceImpl contactService;

    @PostMapping("/create")
    public Contact create(@RequestBody Contact contact){
        Contact newContact = ContactFactory.addContact(contact.getCellphoneNo(), contact.getHomePhone(),contact.getEmail(), contact.getDetails());
        return contactService.create(newContact);
    }

    @GetMapping("/read/{id}")
    public Contact read(@PathVariable String id){
        return contactService.read(id);
    }

    @PostMapping("/update")
    public Contact update(@RequestBody Contact contact){
        return contactService.update(contact);
    }
    @GetMapping("/all")
    public Set<Contact> getAll(){
        return contactService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return contactService.delete(id);
    }
}
