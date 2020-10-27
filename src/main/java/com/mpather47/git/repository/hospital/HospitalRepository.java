package com.mpather47.git.repository.hospital;

import com.mpather47.git.entity.hospital.Hospital;
import com.mpather47.git.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital, String> {

}
