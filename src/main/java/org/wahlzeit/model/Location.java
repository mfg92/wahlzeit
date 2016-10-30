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
