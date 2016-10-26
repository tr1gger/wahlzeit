package org.wahlzeit.model;

/**
 * Class represents Coordinate on the (round) Earth
 */
public class Coordinate {

    public static final int EARTH_RADIUS = 6371;

    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getDistance(Coordinate otherCoordinate){

        /**
         * Formula for calculating distance between two points on a round sphere
         * https://de.wikipedia.org/wiki/Orthodrome
         */

        double phiA = Math.toRadians(latitude);
        double phiB = Math.toRadians(otherCoordinate.getLatitude());

        double lambdaA = Math.toRadians(longitude);
        double lambdaB = Math.toRadians(otherCoordinate.getLongitude());

        double val = Math.sin(phiA) * Math.sin(phiB) + Math.cos(phiA) * Math.cos(phiB) *
                Math.cos(lambdaB - lambdaA);

        return EARTH_RADIUS * Math.acos(val);
    }
}
