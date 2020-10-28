//package com.mpather47.git.repository.person.impl;
//
//import com.mpather47.git.entity.person.Address;
//import com.mpather47.git.entity.person.Contact;
//import com.mpather47.git.repository.person.AddressRepository;
//import com.mpather47.git.repository.person.ContactRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class AddressRepositoryImpl implements AddressRepository {
//    private static AddressRepository repository=null;
//    private Set<Address> addressDB;
//
//    private AddressRepositoryImpl() {this.addressDB = new HashSet<>();}
//
//    public static AddressRepository getRepository(){
//        if(repository==null) repository = new AddressRepositoryImpl();
//        return repository;
//    }
//
//
//    @Override
//    public Set<Address> getAll() {
//        return this.addressDB;
//    }
//
//    @Override
//    public Address create(Address address) {
//        this.addressDB.add(address);
//        return address;
//    }
//
//    @Override
//    public Address read(String id) {
//        Address address = this.addressDB.stream().filter(r -> r.getAddressId().trim().equalsIgnoreCase(id))
//                .findAny().orElse(null);
//        return address;
//    }
//
//    @Override
//    public Address update(Address address) {
//        boolean deleteAddress = delete(address.getAddressId());
//        if(deleteAddress){
//            this.addressDB.add(address);
//            return address;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String id) {
//        Address address = read(id);
//        if(address != null){
//            this.addressDB.remove(address);
//            return true;
//        }
//        return false;
//    }
//}
