package com.mpather47.git.controller.visit;


import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.factory.visit.VisitationFactory;
import com.mpather47.git.services.visit.Impl.VisitationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/visitation")
public class VisitationController {
    @Autowired
    private VisitationServiceImpl visitationService;

    @PostMapping("/create")
    public Visitation createVisitation(@RequestBody Visitation visitation){
        boolean visitationExist = false;
        Visitation newVisitation = VisitationFactory.createVisitation(visitation.getVisitId(),visitation.getPatientId(),visitation.getDoctorId(),visitation.getPrescriptionId(),visitation.getVisitDate());
        if(newVisitation !=null){
            visitationExist = true;

        }

        if (visitationExist){
            return visitationService.create(newVisitation);

        }
        else return VisitationFactory.createVisitation("","","","","");
    }
    @GetMapping("/read/{id}")
    public Visitation read(@PathVariable String id){
        boolean visitationExist= false;
        if(id !=null){
            visitationExist= true;
        }
        if(visitationExist= true){
            return visitationService.read(id);

        }
        else return null;
    }

    @PostMapping("/update")
    public Visitation update(@RequestBody Visitation visitation){
        boolean visitationExist = false;
        if(visitation != null){
            visitationExist = true;

        }
        if(visitationExist){
            return visitationService.update(visitation);

        }
        else return null;
    }
    @GetMapping("/all")
    public Set<Visitation> getAll(){
        return visitationService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        boolean visitationExist= false;
        if(id != null){
            visitationExist = true;
        }

        if(visitationExist){
            return visitationService.delete(id);

        }
        else return false;
    }
}
