package com.mpather47.git.factory;

import com.mpather47.git.entity.Medication;
import com.mpather47.git.entity.Prescription;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicationFactoryTest {

    @Test
    public void createMedication() {
        Medication medication = MedicationFactory.createMedication("112","51","244");
        Assert.assertNotNull(medication);
    }
    
}
