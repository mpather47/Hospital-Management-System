//package com.mpather47.git.repository.person.impl;
//
//import com.mpather47.git.entity.person.Person;
//import com.mpather47.git.repository.person.PersonRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class PersonRepositoryImpl implements PersonRepository {
//    private static PersonRepository repository=null;
//    private Set<Person> personDB;
//
//    private PersonRepositoryImpl() {this.personDB = new HashSet<>();}
//
//    public static PersonRepository getRepository(){
//        if(repository==null) repository = new PersonRepositoryImpl();
//        return repository;
//    }
//
//
//    @Override
//    public Set<Person> getAll() {
//        return this.personDB;
//    }
//
//
//    @Override
//    public Person create(Person person) {
//        this.personDB.add(person);
//        return person;
//    }
//
//    @Override
//    public Person read(String id) {
//        Person person = this.personDB.stream().filter(r -> r.getPersonId().trim().equalsIgnoreCase(id))
//                .findAny().orElse(null);
//                return person;
//    }
//
//    @Override
//    public Person update(Person person) {
//        boolean deletePerson = delete(person.getPersonId());
//        if(deletePerson){
//            this.personDB.add(person);
//            return person;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String id) {
//        Person person = read(id);
//        if(person != null){
//            this.personDB.remove(person);
//            return true;
//        }
//        return false;
//    }
//}
