package com.mpather47.git.entity;

public class Address {
    private String address;
    private int postcode;
    private Person details;

    public Address(Builder builder) {
        this.address = builder.address;
        this.postcode = builder.postcode;
        this.details = builder.details;
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
    public String
    toString() {
        return "Address{" +
                "Address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", details=" + details +
                '}';
    }

    public static class Builder{
        private String address;
        private int postcode;
        private Person details;

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
