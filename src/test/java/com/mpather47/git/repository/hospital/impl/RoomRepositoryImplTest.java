/*
package com.mpather47.git.repository.hospital.impl;

import com.mpather47.git.entity.hospital.Room;
import com.mpather47.git.factory.hospital.HospitalFactory;
import com.mpather47.git.factory.hospital.RoomFactory;
import com.mpather47.git.repository.hospital.RoomRepository;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomRepositoryImplTest {
    private static List e;
    @Autowired
    private static RoomRepository repository;
    private static Helper help = new Helper();
    private static Room room = RoomFactory.createRoom(help.generateId(), e, HospitalFactory.createHospital(help.generateId(), "St Mary", 4567));


    @Test
    public void a_create(){
        Room created = repository.save(room);
        Assert.assertEquals(room.getRoomId(), created.getRoomId());
        System.out.println("Created:" + created);
    }

    @Test
    public void b_read(){
        Room read = repository.findById(room.getRoomId()).orElseGet(null);
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update()
    {
        Room updated = new Room.Builder().copy(room).setRoomId("635335").build();
        updated = repository.save(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void d_delete(){
        boolean deleted = false;
        repository.deleteById(room.getRoomId());
        if (repository.existsById(room.getRoomId())) {
            deleted = true;
        }
        Assert.assertTrue(deleted);
    }

    @Test
    public void e_getAll(){
        System.out.println("Get all: " + repository.findAll());
    }


}
*/
