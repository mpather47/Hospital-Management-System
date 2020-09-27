package com.mpather47.git.services.visit;
import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.services.IService;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface VisitationService extends IService <Visitation,String>{
    Set<Visitation> getAll();
}
