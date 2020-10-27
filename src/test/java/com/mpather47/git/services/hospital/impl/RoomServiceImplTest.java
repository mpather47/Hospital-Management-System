package com.mpather47.git.services.hospital.impl;


import com.mpather47.git.entity.hospital.Room;
import com.mpather47.git.factory.hospital.HospitalFactory;
import com.mpather47.git.factory.hospital.RoomFactory;
import com.mpather47.git.services.hospital.RoomService;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomServiceImplTest {
    //private static List e;
    @Autowired
    private static RoomService service;
    private static Helper help = new Helper();
    private static Room room = RoomFactory.createRoom(help.generateId(), "Equipment Roster A", "Victoria");

    @Test
    public void d_testGetAll() {
        Set<Room> room = service.getAll();
        assertEquals(1,room.size());
        System.out.println("All rooms: " + room);
    }
    @Test
    public void a_testCreate() {
        Room created = service.create(room);
        Assert.assertEquals(room.getRoomId(), created.getRoomId());
        System.out.println("Created:" + created);
    }
    @Test
    public void b_testRead() {
        Room read = service.read(room.getRoomId());
        System.out.println("Read:" + read);
    }
    @Test
    public void c_testUpdate() {
        Room updated = new Room.Builder().copy(room).setRoomId("2342").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_testDelete() {
        boolean deleted = service.delete(room.getRoomId());
        Assert.assertTrue(deleted);
    }
}


