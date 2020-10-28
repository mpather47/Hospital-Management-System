package com.mpather47.git.repository.employee;


import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Set;
@Repository
public interface PositionRepository extends JpaRepository<Position, String> {




}
