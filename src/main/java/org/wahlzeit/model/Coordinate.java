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

/**
 * An interface for coordinates.
 */
public interface Coordinate {


	/**
	 * Calculates the direct distance between two coordinates
	 *
	 * @return The distance between this coordinate and the given one in meters
	 */
	double getDistance(Coordinate otherCoordinate) throws CoordinateException;


	/**
	 *
	 */
	public static class CoordinateException extends Exception{
		public CoordinateException() {
		}

		public CoordinateException(String message) {
			super(message);
		}

		public CoordinateException(String message, Throwable cause) {
			super(message, cause);
		}

		public CoordinateException(Throwable cause) {
			super(cause);
		}

		public CoordinateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}
	}
}
