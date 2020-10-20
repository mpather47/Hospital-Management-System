package com.mpather47.git.entity.person;

public class Gender {
    private int genderId;
    private String genderType;

    public Gender(){}

    public Gender(GenderBuilder genderBuilder){
        this.genderId = genderBuilder.genderId;
        this.genderType = genderBuilder.genderType;
    }

    public int getGenderId() {
        return genderId;
    }

    public String getGenderType() {
        return genderType;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderId=" + genderId +
                ", genderType='" + genderType + '\'' +
                '}';
    }

    public static class GenderBuilder{
        private int genderId;
        private String genderType;

        public GenderBuilder(){}

        public GenderBuilder setGenderId(int genderId) {
            this.genderId = genderId;
            return this;
        }

        public GenderBuilder setGenderType(String genderType) {
            this.genderType = genderType;
            return this;
        }

        public Gender build(){
            return new Gender(this);
        }

        public GenderBuilder copy(Gender gender){
            this.genderId = gender.genderId;
            this.genderType = gender.genderType;
            return this;
        }
    }

}
