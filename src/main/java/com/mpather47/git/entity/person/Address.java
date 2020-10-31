package com.mpather47.git.entity.person;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Address {
    @Id
    private String addressId;
    private String address;
    private int postcode;
    private transient Person details;

    protected Address(){

    }
    private Address(Builder builder) {
        this.addressId = builder.addressId;
        this.address = builder.address;
        this.postcode = builder.postcode;
        this.details = builder.details;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getAddress() {
        return address;
    }

    public int getPostcode() {
        return postcode;
    }

    public Person getDetails() {
        return details;
    }


    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", address='" + address + '\'' +
                ", postcode=" + postcode +
                ", details=" + details +
                '}';
    }

    public static class Builder{
        private String addressId;
        private String address;
        private int postcode;
        private Person details;

        public Builder setAddressId(String addressId) {
            this.addressId = addressId;
            return this;
        }


        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPostcode(int postcode) {
            this.postcode = postcode;
            return this;
        }

        public Builder setDetails(Person details) {
            this.details = details;
            return this;
        }

        public Builder copy(Address address1){
            this.addressId = address1.addressId;
            this.address = address1.address;
            this.postcode = address1.postcode;
            this.details = address1.details;
            return this;
        }

        public Address build(){
            return new Address(this);

        }

    }
}
