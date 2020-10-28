package com.mpather47.git.factory.hospital;

import com.mpather47.git.entity.hospital.Equipment;
import com.mpather47.git.entity.hospital.Room;

public class EquipmentFactory {

    public static Equipment createEquipment (String equip, String name, String desc, int quantity, String details) {
        return new Equipment.Builder()
                .setEquipment(equip)
                .setName(name)
                .setDesc(desc)
                .setQuantity(quantity)
                .setDetails(details)
                .build();
    }
}
