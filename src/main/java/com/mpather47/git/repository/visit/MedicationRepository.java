package com.mpather47.git.repository.visit;

import com.mpather47.git.entity.visit.Medication;
import com.mpather47.git.repository.IRepository;
import java.util.Set;

public interface MedicationRepository extends IRepository<Medication, String>{
    Set<Medication> getAll();
}
