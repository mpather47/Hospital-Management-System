package com.mpather47.git.services.employee.impl;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.repository.employee.PositionRepository;

import com.mpather47.git.services.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service


public class PositionServiceImpl  implements PositionService {

    private static PositionService service= null;

    @Autowired
    private PositionRepository repository;

    @Override
    public Set<Position> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());

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
        return this.repository.save(position);
    }

    @Override
    public Position read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Position update(Position position) {
        if (this.repository.existsById(position.getPositionCode()))
        if(this.repository.existsById(position.getPositionStatus()))
        {
            return this.repository.save(position);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if(this.repository.existsById(s)) return false;
        else return true;
    }
}