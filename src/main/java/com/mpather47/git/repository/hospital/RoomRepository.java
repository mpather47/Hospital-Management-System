package com.mpather47.git.repository.hospital;

import com.mpather47.git.entity.hospital.Room;
import com.mpather47.git.repository.IRepository;
import java.util.Set;

public interface RoomRepository extends IRepository<Room, String> {
    Set<Room> getAll();
}