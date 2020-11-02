/*
package com.mpather47.git.repository.visit.Impl;


import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.repository.visit.VisitationRepository;

import java.util.HashSet;
import java.util.Set;
@Deprecated
public class VisitationRepositoryImpl implements VisitationRepository{

    private static VisitationRepository repository=null;
    private Set<Visitation> visitationDB;

    private VisitationRepositoryImpl() {this.visitationDB = new HashSet<>();}

    public static VisitationRepository getRepository(){
        if(repository==null) repository = new VisitationRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Visitation> getAll() {
        return this.visitationDB;
    }


    @Override
    public Visitation create(Visitation visitation) {
        this.visitationDB.add(visitation);
        return visitation;
    }

    @Override
    public Visitation read(String id) {
        Visitation visitation = this.visitationDB.stream().filter(r -> r.getVisitId().trim().equalsIgnoreCase(id))
                .findAny().orElse(null);
        return visitation;
    }

    @Override
    public Visitation update(Visitation visitation) {
        boolean deleteVistation = delete(visitation.getVisitId());
        if(deleteVistation){
            this.visitationDB.add(visitation);
            return visitation;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Visitation visitation = read(id);
        if(visitation != null){
            this.visitationDB.remove(visitation);
            return true;
        }
        return false;
    }
}
*/
