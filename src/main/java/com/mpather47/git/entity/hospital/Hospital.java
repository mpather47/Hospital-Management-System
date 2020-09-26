package com.mpather47.git.entity.hospital;

public class Hospital {
    private String hospitalId;
    private String hospitalName;
    private int hospitalNumber;

    private Hospital() {

    }

    private Hospital(Builder b){
        this.hospitalId = b.hospitalId;
        this.hospitalName = b.hospitalName;
        this.hospitalNumber = b.hospitalNumber;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public int getHospitalNumber() {
        return hospitalNumber;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalId='" + hospitalId + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", hospitalNumber='" + hospitalNumber + '\'' +
                '}';
    }

    public static class Builder{
        private String hospitalId;
        private String hospitalName;
        private int hospitalNumber;


       public Builder setHospitalId(String hospitalId) {
           this.hospitalId = hospitalId;
           return this;
       }

        public Builder setHospitalName(String hospitalName) {
            this.hospitalName = hospitalName;
            return this;
        }

        public Builder setHospitalNumber(int hospitalNumber){
            this.hospitalNumber = hospitalNumber;
            return this;
        }

        public Builder copy(Hospital h){
            this.hospitalId = h.hospitalId;
            this.hospitalName = h.hospitalName;
            this.hospitalNumber = h.hospitalNumber;
            return this;
        }

        public Hospital build(){
            return new Hospital(this);
        }
    }
}
