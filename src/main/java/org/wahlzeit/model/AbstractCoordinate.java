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

	/**
	 *
	 * @param otherCoordinate
	 * @return
	 * @methodtype get
	 */
	@Override
	public double getDistance(Coordinate otherCoordinate) {
		Objects.requireNonNull(otherCoordinate, "Coordinate parameter must not be null.");

		if (!(otherCoordinate instanceof AbstractCoordinate)) {
			throw new IllegalArgumentException("Can only calculate distance for AbstractCoordinate classes");
		}
		return doGetDistance((AbstractCoordinate) otherCoordinate);
	}

	/**
	 *
	 * @param other
	 * @return
	 * @methodtype get
	 */
	private double doGetDistance(AbstractCoordinate other) {
		double dx = getX() - other.getX();
		double dy = getY() - other.getY();
		double dz = getZ() - other.getZ();
		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}

	/**
	 * @methodtype get
	 */
	public abstract double getX();

	/**
	 * @methodtype get
	 */
	public abstract double getY();

	/**
	 * @methodtype get
	 */
	public abstract double getZ();
}
