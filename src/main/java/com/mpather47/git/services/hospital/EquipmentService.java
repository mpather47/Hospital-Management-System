package com.mpather47.git.services.hospital;

import com.mpather47.git.entity.hospital.Equipment;
import com.mpather47.git.services.IService;
import java.util.Set;

public interface EquipmentService extends IService<Equipment, String> {
    Set<Equipment> getAll();

    //business logic here
}
