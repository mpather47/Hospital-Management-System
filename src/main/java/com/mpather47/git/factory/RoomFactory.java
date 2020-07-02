package com.mpather47.git.factory;

import com.mpather47.git.entity.Hospital;
import com.mpather47.git.entity.Room;

import java.util.List;

public class RoomFactory {
    public static Room createRoom(String roomId, List equipment, Hospital details) {
        Room room = new Room.Builder()
                .setRoomId(roomId)
                .setEquipment(equipment)
                .setDetails(details)
                .build();
        return room;
    }
}
