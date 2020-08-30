package com.mpather47.git.factory.employee;

import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.factory.employee.PositionFactory;
import org.junit.Assert;
import org.junit.Test;

public class PositionFactoryTest {

    @Test
    public void createPosition() {

        Position position = PositionFactory.createPosition("" ,"Negetive");
        Assert.assertNotNull(position);



    }
}