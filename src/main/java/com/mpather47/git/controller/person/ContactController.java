package com.mpather47.git.controller.person;

import com.mpather47.git.entity.employee.Employee;
import com.mpather47.git.entity.person.Contact;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.factory.person.ContactFactory;
import com.mpather47.git.factory.person.PersonFactory;
import com.mpather47.git.services.employee.impl.EmployeeServiceImpl;
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
        boolean contactExist = false;
        Contact newContact = ContactFactory.addContact(contact.getCellphoneNo(), contact.getHomePhone(),contact.getEmail(), contact.getDetails());
        if(contact !=null){
            contactExist = true;
        }

        if(contactExist){
            return contactService.create(newContact);
        }

        else return ContactFactory.addContact(0,0,null,null);

    }

    @GetMapping("/read/{id}")
    public Contact read(@PathVariable String id){
        boolean contactExist = false;
        if(id !=null){
            contactExist = true;
        }

        if(contactExist = true){
            return contactService.read(id);
        }
        else return null;

    }

    @PostMapping("/update")
    public Contact update(@RequestBody Contact contact){
        boolean contactExist = false;
        if(contact !=null) {
            contactExist = true;
        }

        if(contactExist){
            return contactService.update(contact);
        }
        else return null;

    }
    @GetMapping("/all")
    public Set<Contact> getAll(){
        return contactService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        boolean contactExist = false;
        if(id != null){
            contactExist = true;
        }

        if(contactExist){
            return contactService.delete(id);
        }
        else return false;
    }
}
