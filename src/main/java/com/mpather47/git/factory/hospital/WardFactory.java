package com.mpather47.git.factory.hospital;

import com.mpather47.git.entity.hospital.Ward;

public class WardFactory {

    public static Ward createWard(int wardId, int wardSize){
        return new Ward.WardBuilder().setWardId(wardId).setWardSize(wardSize).build();
    }
}
