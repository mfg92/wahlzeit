package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the Coordinate class.
 */
public class CoordinateTest {

    /**
     *
     */
    private static final double EARTH_PERIMETER = 2.0D * Math.PI * Coordinate.EARTH_RADIUS;



    @Before
    public void setup() {

    }

    @Test
    public void testDistance() {
        Coordinate northPole = new Coordinate(90D, 0D);
        Coordinate southPole = new Coordinate(-90D, 0D);
        Coordinate zero = new Coordinate(0D, 0D);
        Coordinate fullEast = new Coordinate(0D, 180D);
        Coordinate fullWest = new Coordinate(0D, 180D);


        Assert.assertEquals(0.5D * EARTH_PERIMETER, northPole.getDistance(southPole), 1.0D);
        Assert.assertEquals(0D, northPole.getDistance(northPole), 1.0D);
        Assert.assertEquals(0D, northPole.getDistance(new Coordinate(90D, 42D)), 1.0D);
        Assert.assertEquals(0.5D * EARTH_PERIMETER, zero.getDistance(new Coordinate(0D, 180D)), 1.0D);
        Assert.assertEquals(0.0D, fullEast.getDistance(fullWest), 1.0D);
    }
}
