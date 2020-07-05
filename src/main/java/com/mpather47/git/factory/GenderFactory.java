package com.mpather47.git.factory;

import com.mpather47.git.entity.Gender;

public class GenderFactory {

    public static Gender createGender(int genderId, String genderType){

        return new Gender.GenderBuilder().
                setGenderId(genderId).setGenderType(genderType).build();
    }
}
