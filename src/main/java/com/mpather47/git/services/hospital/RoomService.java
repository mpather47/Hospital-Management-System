package com.mpather47.git.services.hospital;

import com.mpather47.git.entity.hospital.Room;
import com.mpather47.git.services.IService;
import java.util.Set;

public interface RoomService extends IService<Room, String> {
    Set<Room> getAll();

    //business logic here
}
