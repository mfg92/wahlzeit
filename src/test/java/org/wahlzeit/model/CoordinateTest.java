/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for the Coordinate class.
 */
public class CoordinateTest {

    /**
     *
     */
    private static final double EARTH_PERIMETER = 2.0D * Math.PI * Coordinate.EARTH_RADIUS;

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

    /**
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor() {
        new Coordinate(-91.0D, 0D);
    }

    /**
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2() {
        new Coordinate(0.0D, 180.1D);
    }
}