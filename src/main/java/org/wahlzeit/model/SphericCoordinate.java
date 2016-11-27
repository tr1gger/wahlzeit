package org.wahlzeit.model;
import java.util.Map;

/**
 * class represents SphericCoordinate on earth
 */
public class SphericCoordinate extends AbstractCoordinate {

    static final double EARTH_RADIUS_KM = 6371;

    private double latitude;
    private double longitude;


    /**
     * latitude must be between -90 and 90 && longitude must be between -180 and 180 degree
     *
     * @param latitude  latitude > 0 north, latitude < 0 south
     * @param longitude longitude > 0 east, longitude < 0 west
     */
    public SphericCoordinate(double latitude, double longitude) {

        if (latitude > 90 || latitude < -90 || longitude > 180 || longitude < -180) {
            throw new IllegalArgumentException("coordinate is out of range.");
        }

        this.latitude = latitude;
        this.longitude = longitude;
    }


    double getLatitude() {
        return latitude;
    }


    double getLongitude() {
        return longitude;
    }


    /**
     * gets a coordinate as a map
     * @return Map
     */
    @Override
    public Map<String, Double> getCoordinates() {
        coordinates.put("x", convert().getX());
        coordinates.put("y", convert().getY());
        coordinates.put("z", convert().getZ());
        return coordinates;
    }


    /**
     * calculates the distance between to coordinates depending on the class
     * @param coordinate abstract coordinate
     * @return double
     */
    @Override
    public double getDistance(AbstractCoordinate coordinate) {

        if(coordinate instanceof  SphericCoordinate){
            return doGetDistance((SphericCoordinate) coordinate);

        } else if( coordinate instanceof CartesianCoordinate){
            return doGetDistance(coordinate);

        } else {
            throw new IllegalArgumentException("Not a valid coordinate.");
        }
    }


    /**
     * converts a spherical coordinate to a cartesian coordinate
     * transform spheric coordinate https://de.wikipedia.org/wiki/Kugelkoordinaten
     * @return CartesianCoordinate
     */
    public CartesianCoordinate convert(){

        double theta = Math.toRadians(getLatitude());
        double phi = Math.toRadians(getLongitude());

        double x = EARTH_RADIUS_KM * Math.sin(theta) * Math.cos(phi);
        double y = EARTH_RADIUS_KM * Math.sin(theta) * Math.sin(phi);
        double z = EARTH_RADIUS_KM * Math.cos(theta);

        return new CartesianCoordinate(x, y, z);
    }


    /**
     * calculates the distance using orthodrome
     * @param coordinate spheric coordinate
     * @return double
     */
    private double doGetDistance(SphericCoordinate coordinate) {

        double phiA = Math.toRadians(coordinate.getLatitude());
        double lambdaA = Math.toRadians(coordinate.getLongitude());

        double phiB = Math.toRadians(latitude);
        double lambdaB = Math.toRadians(longitude);

        /**
         * Formula for calculating distance between two points on a round sphere
         * https://de.wikipedia.org/wiki/Orthodrome
         */

        double val = Math.sin(phiA) * Math.sin(phiB)
                + Math.cos(phiA) * Math.cos(phiB) *
                Math.cos(lambdaA - lambdaB);

        return SphericCoordinate.EARTH_RADIUS_KM * Math.acos(val);
    }

}
