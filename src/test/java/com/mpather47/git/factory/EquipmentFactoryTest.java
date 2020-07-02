package com.mpather47.git.factory;

import com.mpather47.git.entity.Equipment;
import com.mpather47.git.entity.Room;
import junit.framework.TestCase;
import org.junit.Assert;

public class EquipmentFactoryTest extends TestCase {
    Room r;
    public void testCreateEquipment() {
        Equipment e = EquipmentFactory.createEquipment("SC125", "Scalpel", "Auxiliary tool", 5, r);
        Assert.assertNotNull(e);
    }
}


