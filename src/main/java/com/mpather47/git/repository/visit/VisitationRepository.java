package com.mpather47.git.repository.visit;

import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface VisitationRepository extends JpaRepository<Visitation, String> {

}

