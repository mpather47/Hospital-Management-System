package com.mpather47.git.repository.hospital;

import com.mpather47.git.entity.hospital.Equipment;
import com.mpather47.git.repository.IRepository;
import java.util.Set;

public interface EquipmentRepository extends IRepository<Equipment, String> {
    Set<Equipment> getAll();
}