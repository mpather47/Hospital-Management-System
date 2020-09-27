package com.mpather47.git.controller.hospital;


import com.mpather47.git.entity.hospital.Hospital;
import com.mpather47.git.factory.hospital.HospitalFactory;
import com.mpather47.git.services.hospital.impl.HospitalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalServiceImpl hospitalService;

    @PostMapping("/create/")
    public Hospital create(@RequestBody Hospital hospital) {
        boolean hospitalExist = false;
        Hospital newHospital = HospitalFactory.createHospital(hospital.getHospitalId(), hospital.getHospitalName(), hospital.getHospitalNumber());
        if (newHospital != null) {
            hospitalExist = true;
        }
        if (hospitalExist) {
            return hospitalService.create(newHospital);
        }
        else
            return HospitalFactory.createHospital(null, null, 0);
    }

    @GetMapping("/read/{id}")
    public Hospital read(@PathVariable String id) {
        boolean hospitalExist = false;
        if (id != null) {
            hospitalExist = true;
        }

        if (hospitalExist) {
            return hospitalService.read(id);
        }
        else
            return null;
    }

    @PostMapping("/update")
    public Hospital update(@RequestBody Hospital hospital) {
        boolean hospitalExist = false;
        if (hospital != null) {
            hospitalExist = true;
        }

        if (hospitalExist) {
            return hospitalService.update(hospital);
        }
        else return null;
    }

    @GetMapping("/all")
    public Set<Hospital> getAll() {
        return hospitalService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        boolean hospitalExist = false;
        if (id != null) {
            hospitalExist = true;
        }

        if (hospitalExist) {
            return hospitalService.delete(id);
        }
        else return false;
    }
}
