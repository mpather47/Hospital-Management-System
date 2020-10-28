package com.mpather47.git.services.person.impl;

import com.mpather47.git.entity.person.Gender;
import com.mpather47.git.repository.person.GenderRepository;
import com.mpather47.git.services.person.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderRepository repository;
    private static GenderServiceImpl service = null;

    public GenderServiceImpl() {
    }

    public static GenderService getService() {
        if (service == null)
            service = new GenderServiceImpl();
        return service;
    }

    @Override
    public List<Gender> getAll() {
        return repository.findAll();
    }

    @Override
    public Gender create(Gender gender) {
        return repository.save(gender);
    }

    @Override
    public Gender read(Integer genderId) {
        Optional<Gender>genderOptional = repository.findById(genderId);
        return genderOptional.orElse(null);
    }

    @Override
    public Gender update(Gender gender) {
        return repository.save(gender);
    }

    @Override
    public boolean delete(Integer genderId) {
        if(read(genderId)!=null){
            repository.deleteById(genderId);
            return true;
        }
return false;
    }
}
