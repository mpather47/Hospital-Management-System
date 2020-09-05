package com.mpather47.git.services.employee.Impl;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.entity.person.Person;
import com.mpather47.git.repository.employee.EmployeeRepository;
import com.mpather47.git.repository.employee.PositionRepository;
import com.mpather47.git.repository.employee.impl.EmployeeRepositoryImpl;
import com.mpather47.git.repository.employee.impl.PositionRepositoryImpl;
import com.mpather47.git.services.employee.EmployeeService;
import com.mpather47.git.services.employee.PositionService;
import com.mpather47.git.services.person.PersonService;

import java.util.Set;

public class PositionServiceImpl implements PositionService {

    private static PositionService service=null;
    private PositionRepository repository;

    private PositionServiceImpl() {
        this.repository = PositionRepositoryImpl.getRepository();
    }
    public static PositionService getService(){
        if(service==null) service = new PositionServiceImpl();
        return service;
    }
    @Override
    public Set<Position> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Position create(Position position) {
        return this.repository.create(position);
    }

    @Override
    public Position read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Position update(Position position) {
        return this.repository.update(position);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);

    }
}
