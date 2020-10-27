package com.mpather47.git.services.employee.impl;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.repository.employee.JobRepository;
import com.mpather47.git.repository.employee.PositionRepository;
import com.mpather47.git.repository.employee.impl.JobRepositoryImpl;
import com.mpather47.git.repository.employee.impl.PositionRepositoryImpl;
import com.mpather47.git.services.employee.JobService;
import com.mpather47.git.services.employee.PositionService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service


public class PositionServiceImpl  implements PositionService {

    private static PositionService service= null;
    private PositionRepository repository;

    private PositionServiceImpl() {

        this.repository= PositionRepositoryImpl.getRepository();

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
    public Set<Position> getAllStartingWithA() {
        Set<Position> positions = getAll();
        Set<Position>positionsWithA = new HashSet<>();
        for(Position position : positions){

            if(position.getPositionCode().trim().toLowerCase().startsWith("a")){
                positionsWithA.add(position);


            }
        }
        return positionsWithA;
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
