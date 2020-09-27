package com.mpather47.git.controller.visit;


import com.mpather47.git.entity.visit.Prescription;

import com.mpather47.git.factory.visit.PrescriptionFactory;
import com.mpather47.git.services.visit.Impl.PrescriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionServiceImpl prescriptionService;

    @PostMapping("/create")
    public Prescription createPrescription(@RequestBody Prescription prescription){
        boolean prescriptionExist = false;
        Prescription newPrescription = PrescriptionFactory.createPrescription(prescription.getPrescriptionId(),prescription.getMedicationId(),prescription.getVisitId());
        if(newPrescription !=null){
            prescriptionExist = true;

        }

        if (prescriptionExist){
            return prescriptionService.create(newPrescription);

        }
        else return PrescriptionFactory.createPrescription("","","");
    }
    @GetMapping("/read/{id}")
    public Prescription read(@PathVariable String id){
        boolean prescriptionExist = false;
        if(id !=null){
            prescriptionExist = true;
        }
        if(prescriptionExist = true){
            return prescriptionService.read(id);

        }
        else return null;
    }

    @PostMapping("/update")
    public Prescription update(@RequestBody Prescription prescription){
        boolean prescriptionExist = false;
        if(prescription != null){
            prescriptionExist = true;

        }
        if(prescriptionExist){
            return prescriptionService.update(prescription);

        }
        else return null;
    }
    @GetMapping("/all")
    public Set<Prescription> getAll(){
        return prescriptionService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        boolean prescriptionExist = false;
        if(id != null){
            prescriptionExist = true;
        }

        if(prescriptionExist){
            return prescriptionService.delete(id);

        }
        else return false;
    }
}
