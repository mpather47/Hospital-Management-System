package repository.hospital.impl.hospital;

import com.mpather47.git.entity.hospital.Equipment;
import com.mpather47.git.factory.hospital.EquipmentFactory;
import com.mpather47.git.factory.hospital.HospitalFactory;
import com.mpather47.git.factory.hospital.RoomFactory;
import com.mpather47.git.repository.hospital.EquipmentRepository;
import com.mpather47.git.repository.hospital.impl.EquipmentRepositoryImpl;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EquipmentRepositoryImplTest {
    private static List e;
    private static EquipmentRepository repository = EquipmentRepositoryImpl.getRepository();
    private static Helper help = new Helper();
    private static Equipment equipment = EquipmentFactory.createEquipment(help.generateId(), "Scalpel", "Bladed Instrument utilized in surgery",
            4, RoomFactory.createRoom(help.generateId(),e , HospitalFactory.createHospital(help.generateId(), "St Mary", 1456)));


    @Test
    public void a_create(){
        Equipment created = repository.create(equipment);
        Assert.assertEquals(equipment.getEquipmentId(), created.getEquipmentId());
        System.out.println("Created:" + created);
    }

    @Test
    public void b_read(){
        Equipment read = repository.read(equipment.getEquipmentId());
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update()
    {
        Equipment updated = new Equipment.Builder().copy(equipment).setName("Jumper").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void d_delete(){
        boolean deleted = repository.delete(equipment.getEquipmentId());
        Assert.assertTrue(deleted);
    }

    @Test
    public void e_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }


}