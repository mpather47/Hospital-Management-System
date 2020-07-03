package com.mpather47.git.entity;

public class Contact {
    private int cellphoneNo;
    private int homePhone;
    private String email;
    private Person details;



    public Contact(Builder builder) {
        this.cellphoneNo = builder.cellphoneNo;
        this.homePhone = builder.homePhone;
        this.email = builder.email;
        this.details = builder.details;
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
                "cellphoneNo='" + cellphoneNo + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", email='" + email + '\'' +
                ", details=" + details +
                '}';
    }

    public static class Builder{
        private int cellphoneNo;
        private int homePhone;
        private String email;
        private Person details;

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
