package com.mpather47.git.services.hospital.impl;

import com.mpather47.git.entity.hospital.Room;
import com.mpather47.git.repository.hospital.RoomRepository;
import com.mpather47.git.repository.hospital.impl.RoomRepositoryImpl;
import com.mpather47.git.services.hospital.RoomService;

import java.util.Set;

public class RoomServiceImpl implements RoomService {
    private static RoomService service = null;
    private RoomRepository repository;

    private RoomServiceImpl() {
        this.repository = RoomRepositoryImpl.getRepository();
    }

    public static RoomService getService() {
        if (service == null) service = new RoomServiceImpl();
        return service;
    }


    @Override
    public Set getAll() {

        return this.repository.getAll();
    }

    @Override
    public Room create(Room room) {
        return this.repository.create(room);
    }

    @Override
    public Room read(String s) {

        return this.repository.read(s);
    }

    @Override
    public Room update(Room room) {

        return this.repository.update(room);
    }

    @Override
    public boolean delete(String s) {

        return this.repository.delete(s);
    }
}

