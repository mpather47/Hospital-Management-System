package com.mpather47.git.factory.visit;

import com.mpather47.git.entity.visit.Medication;
import com.mpather47.git.factory.visit.MedicationFactory;
import org.junit.Assert;
import org.junit.Test;

public class MedicationFactoryTest {

    @Test
    public void createMedication() {
        Medication medication = MedicationFactory.createMedication("112","51","244");
        Assert.assertNotNull(medication);
    }
    
}
