package com.mpather47.git.repository.person.impl.hospital;

import com.mpather47.git.entity.hospital.Room;
import com.mpather47.git.factory.hospital.HospitalFactory;
import com.mpather47.git.factory.hospital.RoomFactory;
import com.mpather47.git.repository.hospital.RoomRepository;
import com.mpather47.git.repository.hospital.impl.RoomRepositoryImpl;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomRepositoryImplTest {
    private static List e;
    private static RoomRepository repository = RoomRepositoryImpl.getRepository();
    private static Helper help = new Helper();
    private static Room room = RoomFactory.createRoom(help.generateId(), e, HospitalFactory.createHospital(help.generateId(), "St Mary", 4567));


    @Test
    public void a_create(){
        Room created = repository.create(room);
        Assert.assertEquals(room.getRoomId(), created.getRoomId());
        System.out.println("Created:" + created);
    }

    @Test
    public void b_read(){
        Room read = repository.read(room.getRoomId());
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update()
    {
        Room updated = new Room.Builder().copy(room).setRoomId("635335").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void d_delete(){
        boolean deleted = repository.delete(room.getRoomId());
        Assert.assertTrue(deleted);
    }

    @Test
    public void e_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }


}
