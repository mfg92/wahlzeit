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

import org.wahlzeit.utils.PatternInstance;
import org.wahlzeit.utils.ValueFactory;

/**
 * A coordinate class for cartesian coordinates
 */
@PatternInstance(patternName = "Value Object", participants = {"CartesianCoordinate"} )
public class CartesianCoordinate extends AbstractCoordinate {

	/**
	 *
	 */
	private static final ValueFactory<CartesianCoordinate> factory =
			new ValueFactory<>(CartesianCoordinate.class, Double.TYPE, Double.TYPE, Double.TYPE);

	/**
	 *
	 */
	@PatternInstance(patternName = "Factory Method", participants = {"CartesianCoordinate"} )
	public static CartesianCoordinate get(double x, double y, double z){
		return factory.getValueObject(x,y,z);
	}



	/**
	 * in meters
	 */
	private final double x, y, z;

	/**
	 *
	 * @param x
	 * @param y
	 * @param z
	 */
	protected CartesianCoordinate(double x, double y, double z) {
		assertValidDouble(x);
		assertValidDouble(y);
		assertValidDouble(z);

		this.x = x;
		this.y = y;
		this.z = z;

		assert this.x == x;
		assert this.y == y;
		assert this.z == z;
	}

	/**
	 * @methodtype get
	 */
	@Override
	public double getX() {
		return x;
	}

	/**
	 * @methodtype get
	 */
	@Override
	public double getY() {
		return y;
	}

	/**
	 * @methodtype get
	 */
	@Override
	public double getZ() {
		return z;
	}
}
