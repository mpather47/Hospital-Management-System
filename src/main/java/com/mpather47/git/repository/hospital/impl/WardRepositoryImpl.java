//package com.mpather47.git.repository.hospital.impl;
//
//import com.mpather47.git.entity.hospital.Ward;
//import com.mpather47.git.repository.hospital.WardRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class WardRepositoryImpl implements WardRepository {
//
//    private Set<Ward> wards;
//    private static WardRepository wardRepository = null;
//
//    public WardRepositoryImpl() {
//        this.wards = new HashSet<>();
//    }
//
//    public static WardRepository getWardRepository(){
//        if (wardRepository == null)
//            wardRepository = new WardRepositoryImpl();
//        return wardRepository;
//    }
//
//    @Override
//    public Ward create(Ward ward){
//        wards.add(ward);
//        return ward;
//    }
//
//    @Override
//    public Ward read(final Integer wardId){
//        return wards.stream().filter(ward -> ward.getWardId() == wardId).
//                findAny().orElse(null);
//    }
//
//    @Override
//    public Ward update(Ward ward){
//        Ward oldWard = read(ward.getWardId());
//        if (oldWard != null){
//            wards.remove(oldWard);
//            wards.add(ward);
//        }
//        return ward;
//    }
//
//    @Override
//    public boolean delete(Integer wardId){
//        boolean deleted = false;
//        Ward oldWard = read(wardId);
//        if (oldWard != null) {
//            wards.remove(oldWard);
//            deleted = true;
//        }
//        return deleted;
//    }
//
//    @Override
//    public Set<Ward> getAll() {
//        return wards;
//    }
//}
