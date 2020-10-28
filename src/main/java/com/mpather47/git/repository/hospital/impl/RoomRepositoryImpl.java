/*
package com.mpather47.git.repository.hospital.impl;
import com.mpather47.git.entity.hospital.Room;
import com.mpather47.git.repository.hospital.RoomRepository;

import java.util.HashSet;
import java.util.Set;

//public class RoomRepositoryImpl implements RoomRepository {
    private static RoomRepository repository = null;
    private Set<Room> roomDB;


    private RoomRepositoryImpl() {
        this.roomDB = new HashSet<>();
    }

    public static RoomRepository getRepository() {
        if(repository == null) repository = new RoomRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Room> getAll() {
        return this.roomDB;
    }

    @Override
    public Room create(Room room) {
        this.roomDB.add(room);
        return room;
    }

    @Override
    public Room read(String s) {
        Room room = this.roomDB.stream().filter(r -> r.getRoomId().trim().equalsIgnoreCase(s)).findAny().orElse(null);
        return room;
    }

    @Override
    public Room update(Room room) {
        boolean deleteRoom = delete(room.getRoomId());
        if (deleteRoom) {
            this.roomDB.add(room);
            return room;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Room room = read(s);
        if (room != null) {
            this.roomDB.remove(room);
            return true;
        }
        return false;
    }
}


*/
