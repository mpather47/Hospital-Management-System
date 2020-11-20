package com.mpather47.git.factory.visit;

import com.mpather47.git.entity.visit.Visitation;
import com.mpather47.git.factory.visit.VisitationFactory;
import org.junit.Assert;
import org.junit.Test;

public class VisitationFactoryTest {

    @Test
    public void createVisitation() {
        Visitation visit = VisitationFactory.createVisitation("13","1123","7032","2020/05/7");
        Assert.assertNotNull(visit);
    }
    
}
