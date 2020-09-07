package com.mpather47.git.services.person.impl;

import com.mpather47.git.entity.person.Gender;
import com.mpather47.git.repository.person.GenderRepository;
import com.mpather47.git.repository.person.impl.GenderRepositoryImpl;
import com.mpather47.git.services.person.GenderService;

import java.util.Set;

public class GenderServiceImpl implements GenderService {

    private GenderRepository repository;
    private static GenderService service = null;

    public GenderServiceImpl() {
        this.repository = GenderRepositoryImpl.getGenderRepository();
    }

    public static GenderService getService() {
        if (service == null)
            service = new GenderServiceImpl();
        return service;
    }

    @Override
    public Set<Gender> getAll() {
        return repository.getAll();
    }

    @Override
    public Gender create(Gender gender) {
        return repository.create(gender);
    }

    @Override
    public Gender read(Integer genderId) {
        return repository.read(genderId);
    }

    @Override
    public Gender update(Gender gender) {
        return repository.update(gender);
    }

    @Override
    public boolean delete(Integer genderId) {
        return repository.delete(genderId);
    }
}
