package com.mpather47.git.factory.visit;

import com.mpather47.git.entity.visit.Prescription;
import com.mpather47.git.factory.visit.PrescriptionFactory;
import org.junit.Assert;
import org.junit.Test;

public class PrescriptionFactoryTest {

    @Test
    public void createPrescription() {
        Prescription prescription = PrescriptionFactory.createPrescription("112","51");
        Assert.assertNotNull(prescription);
    }
    
}
