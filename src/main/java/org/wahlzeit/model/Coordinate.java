package org.wahlzeit.model;



/**
 * A class that represents a polar coordinate on the earth.
 */
public class Coordinate {

    /**
     *  Radius of the earth in meters
     */
    public static final double EARTH_RADIUS = 6_371_000D;

    /**
     * Latitude in degrees, range [-90,90]
     * Longitude in degrees, range [-180, 180]
     */
    private double latitude;
    private double longitude;

    /**
     * @methodtype constructor
     */
    public Coordinate(double latitude, double longitude) {
        if(!checkArguments(latitude, longitude)) {
            throw new IllegalArgumentException("Arguments are out of range: latitude [-90,90], longitude [-180, 180]");
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     *
     * @param latitude
     * @param longitude
     * @return true if arguments are in valid range
     */
    private boolean checkArguments(double latitude, double longitude) {
        return latitude <= 90.0D && latitude >= -90.0D
                && longitude <= 180.0D && longitude >= -180.0D;
    }

    /**
     * Calculates the distance between two coordinates on earth
     * https://en.wikipedia.org/wiki/Great-circle_distance
     * @methodtype int-query
     * @return The ditance between this coordinate and the given one in meters
     */
    public double getDistance(Coordinate otherCoordinate) {
        // make degrees to radians
        double phi1 = Math.toRadians(latitude);
        double phi2 = Math.toRadians(otherCoordinate.latitude);
        double lambda1 = Math.toRadians(longitude);
        double lambda2 = Math.toRadians(otherCoordinate.longitude);

        // compute central angle
        double deltaLambda = Math.abs(lambda1 - lambda2);
        double centralAngle = Math.acos(
                Math.sin(phi1) * Math.sin(phi2)
                + Math.cos(phi1) * Math.cos(phi2) * Math.cos(deltaLambda)
        );
        return EARTH_RADIUS * centralAngle;
    }

    /**
     * @methodtype set
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
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;

        Coordinate that = (Coordinate) o;

        if (Double.compare(that.latitude, latitude) != 0) return false;
        return Double.compare(that.longitude, longitude) == 0;

    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
