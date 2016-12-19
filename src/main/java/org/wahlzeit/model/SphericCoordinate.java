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


import org.wahlzeit.utils.ValueFactory;

/**
 * A class that represents a polar coordinate on the earth.
 */
public class SphericCoordinate extends AbstractCoordinate {

	/**
	 *
	 */
	private static final ValueFactory<SphericCoordinate> factory =
			new ValueFactory<>(SphericCoordinate.class, Double.TYPE, Double.TYPE, Double.TYPE);

	/**
	 *
	 */
	public static SphericCoordinate get(double latitude, double longitude){
		return get(latitude, longitude, EARTH_RADIUS);
	}

	/**
	 *
	 */
	public static SphericCoordinate get(double latitude, double longitude, double radius){
		return factory.getValueObject(latitude, longitude, radius);
	}

	/**
	 * Radius of the earth in meters
	 */
	public static final double EARTH_RADIUS = 6_371_000D;

	/**
	 * Latitude in degrees, range [-90,90]
	 * Longitude in degrees, range [-180, 180]
	 */
	private final double latitude;
	private final double longitude;
	private final double radius;

	/**
	 * @methodtype constructor
	 */
	private SphericCoordinate() {
		this(0, 0);
	}

	/**
	 * Sets the radius to the radius of the earth
	 *
	 * @param latitude
	 * @param longitude
	 * @methodtype constructor
	 */
	protected SphericCoordinate(double latitude, double longitude) {
		this(latitude, longitude, EARTH_RADIUS);
	}

	/**
	 * @param latitude
	 * @param longitude
	 * @param radius    in meters
	 * @methodtype constructor
	 */
	protected SphericCoordinate(double latitude, double longitude, double radius) {
		assertValidDouble(latitude);
		assertValidDouble(longitude);
		assertValidDouble(radius);

		if(latitude > 90.0D || latitude < -90.0D) {
			throw new IllegalArgumentException("latitude must be in range [-90,90]");
		}
		if(longitude > 180.0D || longitude < -180.0D) {
			throw new IllegalArgumentException("longitude must be in range [-180,180]");
		}
		if(radius <= 0.0D){
			throw new IllegalArgumentException("radius must be greater zero");
		}

		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;

		assert this.latitude == latitude;
		assert this.longitude == longitude;
		assert this.radius == radius;
	}

	/**
	 * @methodtype get
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @methodtype get
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @methodtype get
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @methodtype get
	 */
	@Override
	public double getX() {
		return radius * Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(longitude));
	}

	/**
	 * @methodtype get
	 */
	@Override
	public double getY() {
		return radius * Math.cos(Math.toRadians(latitude)) * Math.sin(Math.toRadians(longitude));
	}

	/**
	 * @methodtype get
	 */
	@Override
	public double getZ() {
		return radius * Math.sin(Math.toRadians(latitude));
	}

}