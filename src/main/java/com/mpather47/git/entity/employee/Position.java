package com.mpather47.git.entity.employee;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
/**
 * @authour @Pilisa
 * Decription: Entity for Position

 */

public class Position {

     @Id
     private String positionCode;
     private String positionStatus;

     protected Position(){}


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return positionCode.equals(position.positionCode) && Objects.equals(positionStatus, position.positionStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionCode, positionStatus);
    }
}


