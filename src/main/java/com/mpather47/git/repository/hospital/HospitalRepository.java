package com.mpather47.git.repository.hospital;

import com.mpather47.git.entity.hospital.Hospital;
import com.mpather47.git.repository.IRepository;
import java.util.Set;

public interface HospitalRepository extends IRepository<Hospital, String> {
    Set<Hospital> getAll();
}
