package com.mpather47.git.controller.hospital;


import com.mpather47.git.entity.hospital.Room;
import com.mpather47.git.factory.hospital.RoomFactory;
import com.mpather47.git.services.hospital.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomServiceImpl roomService;

    @PostMapping("/create")
    public Room create(@RequestBody Room room) {
        boolean roomExist = false;
        Room newRoom = RoomFactory.createRoom(room.getRoomId(), room.getEquipment(), room.getDetails());
        if (newRoom != null) {
            roomExist = true;
        }
        if (roomExist) {
            return roomService.create(newRoom);
        }
        else
            return RoomFactory.createRoom(null, null, null);
    }

    @GetMapping("/read/{id}")
    public Room read(@PathVariable String id) {
        boolean roomExist = false;
        if (id != null) {
            roomExist = true;
        }

        if (roomExist) {
            return roomService.read(id);
        }
        else
            return null;
    }

    @PostMapping("/update")
    public Room update(@RequestBody Room room) {
        boolean roomExist = false;
        if (room != null) {
            roomExist = true;
        }

        if (roomExist) {
            return roomService.update(room);
        }
        else return null;
    }

    @GetMapping("/all")
    public Set<Room> getAll() {
        return roomService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        boolean roomExist = false;
        if (id != null) {
            roomExist = true;
        }

        if (roomExist) {
            return roomService.delete(id);
        }
        else return false;
    }
}
