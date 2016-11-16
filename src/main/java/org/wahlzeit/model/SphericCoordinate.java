package org.wahlzeit.model;

/**
 * class represents SphericCoordinate on earth
 */
public class SphericCoordinate implements Coordinate<SphericCoordinate>{

    public static final double EARTH_RADIUS_KM = 6371;

    private double latitude;
    private double longitude;
    private double radius;

    /**
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
        return CoordinateUtil.getDistance(this, coordinate);
    }

}
