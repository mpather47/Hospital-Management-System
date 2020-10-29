package com.mpather47.git.entity.hospital;

import java.util.List;

public class Room {
    private String roomId;
    private List equipment;
    private Hospital details;

    private Room() {

    }

    private Room(Builder b){
        this.roomId =b.roomId;
        this.equipment = b.equipment;
        this.details = b.details;
    }

    public String getRoomId() {
        return roomId;
    }

    public List getEquipment() {
        return equipment;
    }

    public Hospital getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", equipment='" + equipment + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    public static class Builder{
        private String roomId;
        private List equipment;
        private Hospital details;


       public Builder setRoomId(String roomId) {
           this.roomId = roomId;
           return this;
       }

        public Builder setEquipment(List equipment) {
            this.equipment = equipment;
            return this;
        }

        public Builder setDetails(Hospital details) {
            this.details = details;
            return this;
        }

        public Builder copy(Room r){
            this.roomId = r.roomId;
            this.equipment = r.equipment;
            this.details = r.details;
            return this;
        }

        public Room build(){
            return new Room(this);
        }
    }
}

