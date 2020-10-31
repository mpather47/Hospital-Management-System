package com.mpather47.git.repository.visit;

import com.mpather47.git.entity.visit.Prescription;
import com.mpather47.git.repository.IRepository;
import java.util.Set;

public interface PrescriptionRepository extends IRepository <Prescription, String>{
    Set<Prescription> getAll();
}
