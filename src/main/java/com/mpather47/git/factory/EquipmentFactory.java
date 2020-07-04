package com.mpather47.git.factory;

import com.mpather47.git.entity.Equipment;
import com.mpather47.git.entity.Room;

public class EquipmentFactory {

    public static Equipment createEquipment (String equip, String name, String desc, int quantity, Room details) {
        Equipment equipment = new Equipment.Builder()
                .setEquipment(equip)
                .setName(name)
                .setDesc(desc)
                .setQuantity(quantity)
                .setDetails(details)
                .build();
        return equipment;
    }
}
