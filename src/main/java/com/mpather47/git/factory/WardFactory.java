package com.mpather47.git.factory;

import com.mpather47.git.entity.Ward;

public class WardFactory {

    public static Ward createWard(int wardId, int wardSize){
        return new Ward.WardBuilder().setWardId(wardId).setWardSize(wardSize).build();
    }
}
