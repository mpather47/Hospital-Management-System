//package com.mpather47.git.repository.person.impl;
//
//import com.mpather47.git.entity.person.Contact;
//import com.mpather47.git.entity.person.Person;
//import com.mpather47.git.repository.person.ContactRepository;
//import com.mpather47.git.repository.person.PersonRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class ContactRepositoryImpl implements ContactRepository {
//    private static ContactRepository repository=null;
//    private Set<Contact> contactDB;
//
//    private ContactRepositoryImpl() {this.contactDB = new HashSet<>();}
//
//    public static ContactRepository getRepository(){
//        if(repository==null) repository = new ContactRepositoryImpl();
//        return repository;
//    }
//
//
//    @Override
//    public Set<Contact> getAll() {
//        return this.contactDB;
//    }
//
//    @Override
//    public Contact create(Contact contact) {
//        this.contactDB.add(contact);
//        return contact;
//    }
//
//    @Override
//    public Contact read(String id) {
//        Contact contact = this.contactDB.stream().filter(r -> r.getContactId().trim().equalsIgnoreCase(id))
//                .findAny().orElse(null);
//        return contact;
//    }
//
//    @Override
//    public Contact update(Contact contact) {
//        boolean deleteAddress = delete(contact.getContactId());
//        if(deleteAddress){
//            this.contactDB.add(contact);
//            return contact;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String id) {
//        Contact contact = read(id);
//        if(contact != null){
//            this.contactDB.remove(contact);
//            return true;
//        }
//        return false;
//    }
//}
