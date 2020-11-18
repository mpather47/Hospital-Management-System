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
@CrossOrigin
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressServiceImpl addressService;

    @PostMapping("/create")
    public Address create(@RequestBody Address address){
        boolean addressExist = false;
        Address newAddress = AddressFactory.addAddress(address.getAddress(),address.getPostcode(),address.getDetails());
        if(newAddress !=null){
            addressExist = true;
        }

        if(addressExist){
            return addressService.create(newAddress);
        }
        else return AddressFactory.addAddress(null,0,null);
    }

    @GetMapping("/read/{id}")
    public Address read(@PathVariable String id){
        boolean addressExist = false;
        if(id !=null){
            addressExist = true;
        }

        if(addressExist = true){
            return addressService.read(id);
        }
        else return null;
    }

    @PostMapping("/update")
    public Address update(@RequestBody Address address){
        boolean addressExist = false;
        if(address !=null){
            addressExist = true;
        }

        if(addressExist = true){
            return addressService.update(address);
        }
        else return null;
    }

    @GetMapping("/all")
    public Set<Address> getAll(){
        return addressService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        boolean addressExist = false;
        if(id !=null){
            addressExist = true;
        }

        if(addressExist = true){
            return addressService.delete(id);
        }
        else return false;
    }
}
