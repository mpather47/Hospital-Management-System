package com.mpather47.git.repository.visit;

import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.repository.IRepository;
import java.util.Set;

public interface VisitationRepository extends IRepository<Visitation, String> {
    Set<Visitation> getAll();
}

