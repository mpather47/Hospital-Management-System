package com.mpather47.git.factory.hospital;

import com.mpather47.git.entity.hospital.Hospital;

public class HospitalFactory {
    public static Hospital createHospital(String hospitalId, String hospitalName, int hospitalNumber) {
        return new Hospital.Builder()
                .setHospitalId(hospitalId)
                .setHospitalName(hospitalName)
                .setHospitalNumber(hospitalNumber)
                .build();
    }
}
