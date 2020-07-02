package com.mpather47.git.factory;

import com.mpather47.git.entity.Hospital;
import com.mpather47.git.entity.Room;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class RoomFactoryTest extends TestCase {
    Hospital h;
    List e;
    public void testCreateRoom() {
        Room r = RoomFactory.createRoom("e21", e, h);
        Assert.assertTrue(r instanceof Room);
    }
}
