package com.mpather47.git.services.employee;

import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.services.IService;

import java.util.Set;

public interface PositionService  extends IService<Position, String> {


    static Position buildPoSition(String partTime) {

        return buildPoSition("PartTime");
    }

    Set<Position> getAll();


    Set<Position>getAllStartingWithA();

}
