package com.mpather47.git.controller.visit;

import java.util.Set;


import com.mpather47.git.entity.visit.Medication;
import com.mpather47.git.factory.visit.MedicationFactory;
import com.mpather47.git.services.visit.Impl.MedicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medication")
public class MedicationController {
    @Autowired
    private MedicationServiceImpl medicationService;

    @PostMapping("/create")
    public Medication createMedication(@RequestBody Medication medication){
        boolean medicationExist = false;
        Medication newMedication = MedicationFactory.createMedication(medication.getMedicationId(),medication.getVisitId(),medication.getPrescriptionId());
        if(newMedication !=null){
            medicationExist = true;

        }

        if (medicationExist){
            return medicationService.create(newMedication);

        }
        else return MedicationFactory.createMedication("","","");
    }
    @GetMapping("/read/{id}")
    public Medication read(@PathVariable String id){
        boolean medicationExist = false;
        if(id !=null){
            medicationExist = true;
        }
        if(medicationExist = true){
            return medicationService.read(id);

        }
        else return null;
    }

    @PostMapping("/update")
    public Medication update(@RequestBody Medication medication){
        boolean medicationExist = false;
        if(medication != null){
            medicationExist = true;

        }
        if(medicationExist){
            return medicationService.update(medication);

        }
        else return null;
    }
    @GetMapping("/all")
    public Set<Medication> getAll(){
        return medicationService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        boolean medicationExist = false;
        if(id != null){
            medicationExist = true;
        }

        if(medicationExist){
            return medicationService.delete(id);

        }
        else return false;
    }
}
