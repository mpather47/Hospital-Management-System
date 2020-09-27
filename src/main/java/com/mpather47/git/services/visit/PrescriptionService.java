package com.mpather47.git.services.visit;
import com.mpather47.git.entity.visit.Prescription;
import com.mpather47.git.services.IService;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface PrescriptionService extends IService<Prescription,String>{
    Set<Prescription> getAll();
}
