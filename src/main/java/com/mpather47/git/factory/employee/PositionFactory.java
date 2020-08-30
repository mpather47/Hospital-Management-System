package com.mpather47.git.factory.employee;

import com.mpather47.git.entity.employee.Position;

public class PositionFactory {

public static Position createPosition (String positionCode, String positionStatus){

    return new Position. Builder().setPositionCode(positionCode).setPositionStatus(positionStatus).build();


}


  //  public static Position buildPosition(String jobTittle) {
   //   return null;
    //}

   // public static Position buildJob(String jobId) {
    //  return null;
   // }
}
