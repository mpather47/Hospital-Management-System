package com.mpather47.git.factory.hospital;

import com.mpather47.git.entity.hospital.Equipment;
import com.mpather47.git.entity.hospital.Room;
import com.mpather47.git.factory.hospital.EquipmentFactory;
import junit.framework.TestCase;
import org.junit.Assert;

public class EquipmentFactoryTest extends TestCase {
    //Room r;
    public void testCreateEquipment() {
        Equipment e = EquipmentFactory.createEquipment("SC125", "Scalpel", "Auxiliary tool", 5, "Room B");
        Assert.assertNotNull(e);
    }
}


