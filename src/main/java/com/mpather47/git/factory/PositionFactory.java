package com.mpather47.git.factory;

import com.mpather47.git.entity.Position;

public class PositionFactory {

public static Position createPosition (String positionCode, String positionStatus){

    return new Position. Builder().setPositionCode(positionCode).setPositionStatus(positionStatus).build();


}



}
