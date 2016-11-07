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
 * A class to hold a Coordinate.
 *
 */
public class Location {

    public static final Location NO_LOCATION = new Location(null);

    /**
     *
     */
    private Coordinate coordinate;

    /**
     * @methodtype constructor
     */
    public Location(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * @methodtype get
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        return coordinate != null ? coordinate.equals(location.coordinate) : location.coordinate == null;

    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return coordinate != null ? coordinate.hashCode() : 0;
    }
}
