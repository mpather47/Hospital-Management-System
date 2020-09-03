package com.mpather47.git.factory.hospital;

import com.mpather47.git.entity.hospital.Ward;
import com.mpather47.git.factory.hospital.WardFactory;
import org.junit.Assert;
import org.junit.Test;

public class WardFactoryTest {

    @Test
    public void createWard(){
        Ward ward = WardFactory.createWard(112, 21);

        Assert.assertNotNull(ward);
    }
}