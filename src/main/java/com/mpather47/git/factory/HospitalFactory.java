package com.mpather47.git.factory;

import com.mpather47.git.entity.Hospital;

public class HospitalFactory {
    public static Hospital createHospital(String hospitalId, String hospitalName, int hospitalNumber) {
        Hospital h = new Hospital.Builder()
                .setHospitalId(hospitalId)
                .setHospitalName(hospitalName)
                .setHospitalNumber(hospitalNumber)
                .build();
        return h;
    }
}
