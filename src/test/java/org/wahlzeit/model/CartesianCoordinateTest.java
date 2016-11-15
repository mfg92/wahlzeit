package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class CartesianCoordinateTest {


	@Test
	public void testDistance() {
		Coordinate zero = new CartesianCoordinate(0.0D, 0.0D, 0.0D);
		Coordinate zeroXOne = new CartesianCoordinate(1.0D, 0.0D, 0.0D);
		Coordinate zeroXMinusOne = new CartesianCoordinate(-1.0D, 0.0D, 0.0D);
		Coordinate one = new CartesianCoordinate(1.0D, 1.0D, 1.0D);

		doTestDistance(zero, zero, 0.0D);
		doTestDistance(zero, zeroXOne, 1.0D);
		doTestDistance(zero, zeroXMinusOne, 1.0D);
		doTestDistance(zero, one, Math.sqrt(3.0D));
	}

	private void doTestDistance(Coordinate a, Coordinate b, double expected){
		Assert.assertEquals(expected, a.getDistance(b), 0.0001D);
		Assert.assertEquals(b.getDistance(a), a.getDistance(b), 0.0001D);
	}

	/**
	 *
	 */
	@Test
	public void testConstructor() {
		new CartesianCoordinate(0.0D, 0.0D, 0.0D);
	}
}
