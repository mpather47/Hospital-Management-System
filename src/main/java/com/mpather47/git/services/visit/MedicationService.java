package com.mpather47.git.services.visit;
import com.mpather47.git.entity.visit.Medication;
import com.mpather47.git.services.IService;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface MedicationService extends IService<Medication,String>{
    Set<Medication> getAll();
}
