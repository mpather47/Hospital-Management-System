package com.mpather47.git.repository.employee;


import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;

import java.util.Set;

public interface PositionRepository extends Repository <Position, String> {

    Set<Position> getAll();


}
