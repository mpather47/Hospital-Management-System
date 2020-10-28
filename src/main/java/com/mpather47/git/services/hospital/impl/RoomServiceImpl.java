package com.mpather47.git.services.hospital.impl;

import com.mpather47.git.entity.hospital.Room;
import com.mpather47.git.repository.hospital.RoomRepository;
import com.mpather47.git.services.hospital.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository repository;

    @Override
    public Set getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Room create(Room room) {
        return this.repository.save(room);
    }

    @Override
    public Room read(String s) {

        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Room update(Room room) {

        return this.repository.save(room);
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (repository.existsById(s)) {
            return false;
        }
        else return true;
        }
    }


