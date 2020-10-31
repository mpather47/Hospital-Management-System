package com.mpather47.git.factory.hospital;

import com.mpather47.git.entity.hospital.Hospital;
import com.mpather47.git.entity.hospital.Room;

import java.util.List;

public class RoomFactory {
    public static Room createRoom(String roomId, String equipment, String details) {
        return new Room.Builder()
                .setRoomId(roomId)
                .setEquipment(equipment)
                .setDetails(details)
                .build();
    }
}
