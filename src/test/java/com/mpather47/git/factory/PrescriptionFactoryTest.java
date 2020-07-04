package com.mpather47.git.factory;

import com.mpather47.git.entity.Prescription;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrescriptionFactoryTest {

    @Test
    public void createPrescription() {
        Prescription prescription = PrescriptionFactory.createPrescription("112","51","244");
        Assert.assertNotNull(prescription);
    }
}