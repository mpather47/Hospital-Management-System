package com.mpather47.git.factory.hospital;

import com.mpather47.git.entity.hospital.Hospital;
import com.mpather47.git.entity.hospital.Room;
import com.mpather47.git.factory.hospital.RoomFactory;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class RoomFactoryTest extends TestCase {
    //Hospital h;
    //List e;
    public void testCreateRoom() {
        Room r = RoomFactory.createRoom("e21", "Equipment list A", "Victoria");
        Assert.assertNotNull(r);
    }
}





