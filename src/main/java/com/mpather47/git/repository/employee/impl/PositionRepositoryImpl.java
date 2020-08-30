package com.mpather47.git.repository.employee.impl;

import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.repository.employee.PositionRepository;

import java.util.HashSet;
import java.util.Set;

public class PositionRepositoryImpl implements PositionRepository {

    private Set<Position> positionDB;

    public PositionRepositoryImpl() {
        this.positionDB = new HashSet<>();
    }

@Override
    public Position create (Position position){

        this.positionDB.add(position);

        return position;
    }

@Override
    public Position read (String positionId) {

        Position position = null;
        for (Position p : this.positionDB) {
            if (p.getPositionStatus().equalsIgnoreCase(positionId)) position=p;
            break;


        }
        return position;

    }



@Override


    public Position update (Position position ){

        Position oldPosition = read(position.getPositionCode());

        if(oldPosition != null){
            this.positionDB.remove(oldPosition);
            this.positionDB.add(position);


        }

        return position;
    }

@Override
    public void delete (String positionId){
        Position position = read(positionId);
        if (position != null) this.positionDB.remove(position);

    }

@Override
    public Set<Position> getAll() {
        return this.positionDB;
    }
}






