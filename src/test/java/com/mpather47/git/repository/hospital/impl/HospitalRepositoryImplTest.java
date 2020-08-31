package com.mpather47.git.repository.person.impl.hospital;

import com.mpather47.git.entity.hospital.Hospital;
import com.mpather47.git.factory.hospital.HospitalFactory;
import com.mpather47.git.repository.hospital.HospitalRepository;
import com.mpather47.git.repository.hospital.impl.HospitalRepositoryImpl;
import com.mpather47.git.utility.Helper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HospitalRepositoryImplTest {
    private static HospitalRepository repository = HospitalRepositoryImpl.getRepository();
    private static Helper help = new Helper();
    private static Hospital hospital = HospitalFactory.createHospital(help.generateId(), "St Mary", 2456);


    @Test
    public void a_create(){
        Hospital created = repository.create(hospital);
        Assert.assertEquals(hospital.getHospitalId(), created.getHospitalId());
        System.out.println("Created:" + created);
    }

    @Test
    public void b_read(){
        Hospital read = repository.read(hospital.getHospitalId());
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update()
    {
        Hospital updated = new Hospital.Builder().copy(hospital).setHospitalName("Red Cross").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void d_delete(){
        boolean deleted = repository.delete(hospital.getHospitalId());
        Assert.assertTrue(deleted);
    }

    @Test
    public void e_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }


}
