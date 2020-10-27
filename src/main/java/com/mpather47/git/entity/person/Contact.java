package com.mpather47.git.entity.person;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Contact  {

    @Id
    private String contactId;
    private int cellphoneNo,homePhone;
    private String email;
    private transient Person details;

    protected Contact(){

    }
    private Contact(Builder builder) {
        this.contactId = builder.contactId;
        this.cellphoneNo = builder.cellphoneNo;
        this.homePhone = builder.homePhone;
        this.email = builder.email;
        this.details = builder.details;
    }

    public String getContactId() {
        return contactId;
    }
    public int getCellphoneNo() {
        return cellphoneNo;
    }

    public int getHomePhone() {
        return homePhone;
    }

    public String getEmail() {
        return email;
    }
    public Person getDetails() {
        return details;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", cellphoneNo=" + cellphoneNo +
                ", homePhone=" + homePhone +
                ", email='" + email + '\'' +
                ", details=" + details +
                '}';
    }

    public static class Builder{
        private String contactId;
        private int cellphoneNo,homePhone;
        private String email;
        private Person details;

        public Builder setContactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder setCellphoneNo(int cellphoneNo) {
            this.cellphoneNo = cellphoneNo;
            return this;
        }

        public Builder setHomePhone(int homePhone) {
            this.homePhone = homePhone;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setDetails(Person details){
            this.details = details;
            return this;
        }
        public Builder copy(Contact contact){
            this.contactId = contact.contactId;
            this.cellphoneNo = contact.cellphoneNo;
            this.homePhone = contact.homePhone;
            this.email = contact.email;
            this.details =contact.details;
            return this;
        }

        public Contact build(){
            return new Contact(this);
        }
    }
}
