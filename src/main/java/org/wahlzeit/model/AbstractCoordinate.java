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
 * An abstract class for coordinates.
 */
public abstract class AbstractCoordinate implements Coordinate {

	public static final double EQUALS_EPSILON  = 1e-5;

	/**
	 *
	 * @param otherCoordinate
	 * @return
	 * @methodtype get
	 */
	@Override
	public double getDistance(Coordinate otherCoordinate) {
		Objects.requireNonNull(otherCoordinate);

		if (!(otherCoordinate instanceof AbstractCoordinate)) {
			throw new IllegalArgumentException("Can only calculate distance for AbstractCoordinate classes");
		}

		double result = doGetDistance((AbstractCoordinate) otherCoordinate);

		assert result >= 0.0;
		return result;
	}

	/**
	 *
	 * @param other
	 * @return
	 * @methodtype get
	 */
	private double doGetDistance(AbstractCoordinate other) {
		Objects.requireNonNull(other);

		double dx = getX() - other.getX();
		double dy = getY() - other.getY();
		double dz = getZ() - other.getZ();
		double result = Math.sqrt(dx * dx + dy * dy + dz * dz);

		assert result >= 0.0;
		return result;
	}

	/**
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AbstractCoordinate)) return false;

		AbstractCoordinate that = (AbstractCoordinate) o;
		return getDistance(that) <= EQUALS_EPSILON;
	}

	/**
	 * @return
	 */
	@Override
	public int hashCode() {
		int result;
		long temp;
		temp = Double.doubleToLongBits(getX());
		result = (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getY());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getZ());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * in meters
	 * @methodtype get
	 */
	public abstract double getX();

	/**
	 * in meters
	 * @methodtype get
	 */
	public abstract double getY();

	/**
	 * in meters
	 * @methodtype get
	 */
	public abstract double getZ();
}
