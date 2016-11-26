package org.wahlzeit.model;

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
    SphericCoordinate(double latitude, double longitude) {

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

    public void visit(Visitor v) {
        v.visit(this);
    }

    CartesianCoordinate convert(){

        /**
         * transform spheric coordinate https://de.wikipedia.org/wiki/Kugelkoordinaten
         */
        double theta = Math.toRadians(getLatitude());
        double phi = Math.toRadians(getLongitude());

        double x = EARTH_RADIUS_KM * Math.sin(theta) * Math.cos(phi);
        double y = EARTH_RADIUS_KM * Math.sin(theta) * Math.sin(phi);
        double z = EARTH_RADIUS_KM * Math.cos(theta);

        return new CartesianCoordinate(x, y, z);
    }

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




    @Override
    public double getDistance(AbstractCoordinate abstractCoordinate) {

        Visitor visitor = new Visitor() {
            double distance;

            @Override
            public double getResult() {
                return distance;
            }

            @Override
            public void visit(CartesianCoordinate cartesianCoordinate) {
                SphericCoordinate sphericCoordinate = cartesianCoordinate.convert();
                distance = doGetDistance(sphericCoordinate);
            }

            @Override
            public void visit(SphericCoordinate sphericCoordinate) {
                distance = doGetDistance(sphericCoordinate);
            }
        };

        abstractCoordinate.visit(visitor);
        return visitor.getResult();
    }

    @Override
    public boolean isEqual(AbstractCoordinate coordinate) {
        return false;
    }
}
