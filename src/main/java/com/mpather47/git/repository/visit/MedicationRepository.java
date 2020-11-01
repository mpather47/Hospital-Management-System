package com.mpather47.git.repository.visit;

import com.mpather47.git.entity.visit.Medication;
import com.mpather47.git.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MedicationRepository extends JpaRepository<Medication, String> {

}
