package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class CartesianCoordinateTest {

	Coordinate zero = new CartesianCoordinate(0.0D, 0.0D, 0.0D);
	Coordinate zeroXOne = new CartesianCoordinate(1.0D, 0.0D, 0.0D);
	Coordinate zeroXMinusOne = new CartesianCoordinate(-1.0D, 0.0D, 0.0D);
	Coordinate one = new CartesianCoordinate(1.0D, 1.0D, 1.0D);

	public CartesianCoordinateTest() throws Coordinate.CoordinateException {
	}

	/**
	 *
	 */
	@Test
	public void testDistance() throws Coordinate.CoordinateException {
		doTestDistance(zero, zero, 0.0D);
		doTestDistance(zero, zeroXOne, 1.0D);
		doTestDistance(zero, zeroXMinusOne, 1.0D);
		doTestDistance(zero, one, Math.sqrt(3.0D));
	}

	/**
	 *
	 */
	@Test(expected = NullPointerException.class)
	public void testDistanceNull() throws Coordinate.CoordinateException {
		doTestDistance(zero, null, 0.0D);
	}

	/**
	 * @param a
	 * @param b
	 * @param expected
	 */
	private void doTestDistance(Coordinate a, Coordinate b, double expected) throws Coordinate.CoordinateException {
		Assert.assertEquals(expected, a.getDistance(b), 0.0001D);
		Assert.assertEquals(b.getDistance(a), a.getDistance(b), 0.0001D);
	}

	/**
	 *
	 */
	@Test()
	public void testInteroperability() throws Coordinate.CoordinateException {
		double radius = 100.0;
		Assert.assertEquals(radius, zero.getDistance(new SphericCoordinate(0.0D, 0.0D, radius)), 0.1);
	}

	/**
	 *
	 */
	@Test()
	public void testConstructor0() throws Coordinate.CoordinateException {
		double x = 1.0D, y = 2.0D, z = 3.0D;
		CartesianCoordinate sc = new CartesianCoordinate(x, y, z);
		Assert.assertEquals(x, sc.getX(), 0.0D);
		Assert.assertEquals(y, sc.getY(), 0.0D);
		Assert.assertEquals(z, sc.getZ(), 0.0D);
	}

	/**
	 *
	 */
	@Test
	public void testConstructor1() throws Coordinate.CoordinateException {
		new CartesianCoordinate(0.0D, 0.0D, 0.0D);
	}
}
