package org.wahlzeit.model;

/**
 * class represents SphericCoordinate on earth
 */
public class SphericCoordinate implements Coordinate<SphericCoordinate>{

    public static final double EARTH_RADIUS_KM = 6371;

    private double latitude;
    private double longitude;

    /** latitude must be between -90 and 90 && longitude must be between -180 and 180 degree
     * @param latitude latitude > 0 north, latitude < 0 south
     * @param longitude longitude > 0 east, longitude < 0 west
     */
    public SphericCoordinate(double latitude, double longitude) {

        if(latitude > 90 || latitude < -90 || longitude > 180 || longitude < -180 ){
            throw new IllegalArgumentException("coordinate is out of range.");
        }

        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }


    @Override
    public double getDistance(SphericCoordinate coordinate){

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
