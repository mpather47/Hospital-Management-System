package com.mpather47.git.repository.visit;

import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface VisitationRepository extends JpaRepository<Visitation, String> {

}

