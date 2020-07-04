package com.mpather47.git.factory;

import com.mpather47.git.entity.Position;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionFactoryTest {

    @Test
    public void createPosition() {

        Position position = PositionFactory.createPosition("" ,"Negetive");
        Assert.assertNotNull(position);



    }
}