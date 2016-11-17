package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class CartesianCoordinateTest {

	Coordinate zero = new CartesianCoordinate(0.0D, 0.0D, 0.0D);
	Coordinate zeroXOne = new CartesianCoordinate(1.0D, 0.0D, 0.0D);
	Coordinate zeroXMinusOne = new CartesianCoordinate(-1.0D, 0.0D, 0.0D);
	Coordinate one = new CartesianCoordinate(1.0D, 1.0D, 1.0D);

	/**
	 *
	 */
	@Test
	public void testDistance() {
		doTestDistance(zero, zero, 0.0D);
		doTestDistance(zero, zeroXOne, 1.0D);
		doTestDistance(zero, zeroXMinusOne, 1.0D);
		doTestDistance(zero, one, Math.sqrt(3.0D));
	}

	/**
	 *
	 * @param a
	 * @param b
	 * @param expected
	 */
	private void doTestDistance(Coordinate a, Coordinate b, double expected){
		Assert.assertEquals(expected, a.getDistance(b), 0.0001D);
		Assert.assertEquals(b.getDistance(a), a.getDistance(b), 0.0001D);
	}

	/**
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInteroperability(){
		zero.getDistance(new SphericCoordinate(0.0D, 0.0D));
	}

	/**
	 *
	 */
	@Test
	public void testConstructor() {
		new CartesianCoordinate(0.0D, 0.0D, 0.0D);
	}
}
