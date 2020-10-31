//package com.mpather47.git.repository.person.impl;
//
//import com.mpather47.git.entity.person.Gender;
//import com.mpather47.git.repository.person.GenderRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class GenderRepositoryImpl implements GenderRepository {
//
//    private Set<Gender> genders;
//    private static GenderRepository genderRepository = null;
//
//    public GenderRepositoryImpl() {
//        this.genders = new HashSet<>();
//    }
//
//    public static GenderRepository getGenderRepository(){
//        if (genderRepository == null)
//            genderRepository = new GenderRepositoryImpl();
//        return genderRepository;
//    }
//
//    @Override
//    public Gender create(Gender gender){
//        genders.add(gender);
//        return gender;
//    }
//
//    @Override
//    public Gender read(Integer genderID){
//        return genders.stream().filter(gender -> gender.getGenderId() == genderID).
//                findAny().orElse(null);
//    }
//
//    @Override
//    public Gender update(Gender gender){
//        Gender oldGender = read(gender.getGenderId());
//        if (oldGender != null){
//            genders.remove(oldGender);
//            genders.add(gender);
//        }
//
//        return gender;
//    }
//
//    @Override
//    public boolean delete(Integer genderId){
//        boolean deleted = false;
//        Gender oldGender = read(genderId);
//        if (oldGender != null){
//            genders.remove(oldGender);
//            deleted = true;
//        }
//
//        return deleted;
//    }
//
//    @Override
//    public Set<Gender> getAll() {
//        return genders;
//    }
//
//}
