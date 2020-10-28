package com.mpather47.git.controller.hospital;

import com.mpather47.git.entity.hospital.Equipment;
import com.mpather47.git.factory.hospital.EquipmentFactory;
import com.mpather47.git.services.hospital.impl.EquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentServiceImpl equipmentService;

    @PostMapping("/create")
    public Equipment create(@RequestBody Equipment equipment) {
        boolean equipmentExist = false;
        Equipment newEquipment = EquipmentFactory.createEquipment(equipment.getEquipmentId(), equipment.getName(), equipment.getDescription(), equipment.getQuantity(), equipment.getDetails());
        if (newEquipment != null) {
            equipmentExist = true;
        }
        if (equipmentExist) {
            return equipmentService.create(newEquipment);
        }
        else
            return EquipmentFactory.createEquipment(null, null, null, 0, null);
    }

    @GetMapping("/read/{id}")
    public Equipment read(@PathVariable String id) {
        boolean equipmentExist = false;
        if (id != null) {
            equipmentExist = true;
        }

        if (equipmentExist) {
            return equipmentService.read(id);
        }
        else
            return null;
    }

    @PostMapping("/update")
    public Equipment update(@RequestBody Equipment equipment) {
        boolean equipmentExist = false;
        if (equipment != null) {
            equipmentExist = true;
        }

        if (equipmentExist) {
            return equipmentService.update(equipment);
        }
        else return null;
    }

    @GetMapping("/all")
    public Set<Equipment> getAll() {
        return equipmentService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        boolean equipmentExist = false;
        if (id != null) {
            equipmentExist = true;
        }

        if (equipmentExist) {
            return equipmentService.delete(id);
        }
        else return false;
    }
}

