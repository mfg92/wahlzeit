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
    public Coordinate coordinate;

    /**
     * @methodtype constructor
     */
    public Location(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
