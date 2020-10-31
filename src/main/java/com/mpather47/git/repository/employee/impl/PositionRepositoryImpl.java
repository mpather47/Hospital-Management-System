/*package com.mpather47.git.repository.employee.impl;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.repository.employee.JobRepository;
import com.mpather47.git.repository.employee.PositionRepository;

import java.util.HashSet;
import java.util.Set;

public class PositionRepositoryImpl implements PositionRepository {
    private static PositionRepository repository=null;
    private Set<Position> positionDB;

    private PositionRepositoryImpl() {this.positionDB = new HashSet<>();}

    public static PositionRepository getRepository(){
        if(repository==null) repository = new PositionRepositoryImpl();
        return repository;
    }
    @Override
    public Set<Position> getAll() {
        return this.positionDB;
    }

    @Override
    public Position create(Position position) {
        this.positionDB.add(position);
        return position;
    }

    @Override
    public Position read(String id) {
        Position position = this.positionDB.stream().filter(r -> r.getPositionCode().trim().equalsIgnoreCase(id))
                .findAny().orElse(null);
        return position;
    }

    @Override
    public Position update(Position position) {
        boolean deleteAddress = delete(position.getPositionCode());
        if(deleteAddress){
            this.positionDB.add(position);
            return position;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Position position = read(id);
        if(position != null){
            this.positionDB.remove(position);
            return true;
        }
        return false;
    }
}

 */

