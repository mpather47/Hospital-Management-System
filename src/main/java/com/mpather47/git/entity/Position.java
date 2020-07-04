package com.mpather47.git.entity;


/**
 * @authour @Pilisa
 * Decription: Entity for Position

 */

public class Position {


     private String positionCode;
     private String positionStatus;

    private Position(Builder builder) {
        this.positionCode= builder.positionCode;
        this.positionStatus= builder.positionStatus;

    }

    public String getPositionCode() {
        return positionCode;
    }

    public String getPositionStatus() {
        return positionStatus;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionCode='" + positionCode + '\'' +
                ", positionStatus='" + positionStatus + '\'' +
                '}';
    }

    public static class Builder{

         private String positionCode,positionStatus;
         public Builder setPositionCode(String positionCode){

             this.positionCode= positionCode;
             return this;

         }
      public Builder setPositionStatus (String positionStatus){

             this.positionStatus = positionStatus;
                     return this;
      }

      public Builder copy (Position position){

             this.positionCode =position.positionCode;
             this.positionStatus= position.positionStatus;
             return this;


      }



     public Position build(){
             return new Position(this);

     }

     }





    }


