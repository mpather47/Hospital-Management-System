package com.mpather47.git.controller.person;

import com.mpather47.git.entity.person.Address;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.factory.person.AddressFactory;
import com.mpather47.git.factory.person.PersonFactory;
import com.mpather47.git.services.person.impl.AddressServiceImpl;
import com.mpather47.git.services.person.impl.GenderServiceImpl;
import com.mpather47.git.services.person.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressServiceImpl addressService;

    @PostMapping("/create")
    public Address create(@RequestBody Address address){
        Address newAddress = AddressFactory.addAddress(address.getAddress(),address.getPostcode(),address.getDetails());
        return addressService.create(newAddress);
    }

    @GetMapping("/read/{id}")
    public Address read(@PathVariable String id){
        return addressService.read(id);
    }

    @PostMapping("/update")
    public Address update(@RequestBody Address address){
        return addressService.update(address);
    }

    @GetMapping("/all")
    public Set<Address> getAll(){
        return addressService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return addressService.delete(id);
    }
}
