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

import java.util.Objects;

/**
 * A coordinate class for cartesian coordinates
 */
public class CartesianCoordinate implements Coordinate {

	private final double x, y, z;

	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}


	/**
	 * @param otherCoordinate
	 * @return
	 */
	@Override
	public double getDistance(Coordinate otherCoordinate) {
		Objects.requireNonNull(otherCoordinate, "Coordinate parameter must not be null.");

		if (!(otherCoordinate instanceof CartesianCoordinate)) {
			throw new IllegalArgumentException("Can only get distance of Coordinates of same type");
		}

		return doGetDistance((CartesianCoordinate) otherCoordinate);
	}

	/**
	 * @param other
	 * @return
	 */
	private double doGetDistance(CartesianCoordinate other) {
		double dx = x - other.x;
		double dy = y - other.y;
		double dz = z - other.z;
		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}

	/**
	 * @methodtype get
	 */
	public double getX() {
		return x;
	}

	/**
	 * @methodtype get
	 */
	public double getY() {
		return y;
	}

	/**
	 * @methodtype get
	 */
	public double getZ() {
		return z;
	}

	/**
	 *
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CartesianCoordinate)) return false;

		CartesianCoordinate that = (CartesianCoordinate) o;

		if (Double.compare(that.x, x) != 0) return false;
		if (Double.compare(that.y, y) != 0) return false;
		return Double.compare(that.z, z) == 0;

	}

	/**
	 *
	 * @return
	 */
	@Override
	public int hashCode() {
		int result;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
