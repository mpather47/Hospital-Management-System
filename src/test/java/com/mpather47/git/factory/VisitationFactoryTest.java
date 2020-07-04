package com.mpather47.git.factory;

import com.mpather47.git.entity.Visitation;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VisitationFactoryTest {

    @Test
    public void createVisitation() {
        Visitation visit = VisitationFactory.createVisitation("1156","13","1123","7032","2020/05/7");
        Assert.assertNotNull(visit);
    }
}