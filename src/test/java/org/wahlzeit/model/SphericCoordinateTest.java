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
public class SphericCoordinateTest {

	/**
	 *
	 */
	private static final double EARTH_PERIMETER = 2.0D * Math.PI * SphericCoordinate.EARTH_RADIUS;
	private static final double EARTH_DIAMETER = 2.0D * SphericCoordinate.EARTH_RADIUS;

	SphericCoordinate northPole = SphericCoordinate.get(90D, 0D);
	SphericCoordinate southPole = SphericCoordinate.get(-90D, 0D);
	SphericCoordinate zero = SphericCoordinate.get(0D, 0D);
	SphericCoordinate fullEast = SphericCoordinate.get(0D, 180D);
	SphericCoordinate fullWest = SphericCoordinate.get(0D, 180D);

	public SphericCoordinateTest() {
	}

	/**
	 *
	 */
	@Test
	public void testDistance() {
		Assert.assertEquals(EARTH_DIAMETER, northPole.getDistance(southPole), 1.0D);
		Assert.assertEquals(0D, northPole.getDistance(northPole), 1.0D);
		Assert.assertEquals(0D, northPole.getDistance(SphericCoordinate.get(90D, 42D)), 1.0D);
		Assert.assertEquals(EARTH_DIAMETER, zero.getDistance(SphericCoordinate.get(0D, 180D)), 1.0D);
		Assert.assertEquals(0.0D, fullEast.getDistance(fullWest), 1.0D);
	}

	/**
	 *
	 */
	@Test
	public void testDistanceWithDifferentRadius() {
		float deltaRadius = 42;
		Assert.assertEquals(deltaRadius,
				zero.getDistance(SphericCoordinate.get(zero.getLatitude(), zero.getLongitude(), zero.getRadius() + deltaRadius)),
				0.1);
	}

	/**
	 *
	 */
	@Test(expected = NullPointerException.class)
	public void testDistanceNull() {
		zero.getDistance(null);
	}

	/**
	 *
	 */
	@Test
	public void testInteroperability() {
		Assert.assertEquals(zero.getRadius(),
				zero.getDistance(CartesianCoordinate.get(0.0, 0.0, 0.0)),
				0.1);
		Assert.assertEquals(0.0,
				zero.getDistance(CartesianCoordinate.get(zero.getRadius(), 0.0, 0.0)),
				0.1);
	}

	/**
	 *
	 */
	@Test()
	public void testConstructor0() {
		double lat = 1.0D, lon = 2.0D, rad = 3.0D;
		SphericCoordinate sc = SphericCoordinate.get(lat, lon, rad);
		Assert.assertEquals(lat, sc.getLatitude(), 0.0D);
		Assert.assertEquals(lon, sc.getLongitude(), 0.0D);
		Assert.assertEquals(rad, sc.getRadius(), 0.0D);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor1() {
		SphericCoordinate.get(-92.0D, 0D);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor2() {
		SphericCoordinate.get(0.0D, 180.1D);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor3() {
		SphericCoordinate.get(0.0D, 0.0D, 0);
	}
}