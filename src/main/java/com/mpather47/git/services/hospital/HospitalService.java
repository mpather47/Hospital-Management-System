package com.mpather47.git.services.hospital;

import com.mpather47.git.entity.hospital.Hospital;
import com.mpather47.git.services.IService;
import java.util.Set;

public interface HospitalService extends IService <Hospital, String> {
    Set<Hospital> getAll();

    //Unique business logic here

}
