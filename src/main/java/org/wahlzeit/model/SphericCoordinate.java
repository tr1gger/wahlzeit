package org.wahlzeit.model;

/**
 * class represents SphericCoordinate on earth
 */
public class SphericCoordinate extends AbstractCoordinate {

    static final double EARTH_RADIUS_KM = 6371;

    private double latitude;
    private double longitude;
    private double radius;

    /**
     * latitude must be between -90 and 90 && longitude must be between -180 and 180 degree
     *
     * @param latitude  latitude > 0 north, latitude < 0 south
     * @param longitude longitude > 0 east, longitude < 0 west
     */
    public SphericCoordinate(double latitude, double longitude) {
        assert classInvariants();

        assert isValidDouble(latitude);
        assert isValidDouble(longitude);


        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = EARTH_RADIUS_KM;

        CartesianCoordinate cartesianCoordinate = convertToCartesianCoordinate();

        this.x = cartesianCoordinate.getX();
        this.y = cartesianCoordinate.getY();
        this.z = cartesianCoordinate.getZ();

        assert classInvariants();
    }


    /**
     * constructor for spheric coordinates and variable radius
     * @param latitude  latitude > 0 north, latitude < 0 south
     * @param longitude longitude > 0 east, longitude < 0 west
     * @param radius radius >= 0
     */
    public SphericCoordinate(double latitude, double longitude, double radius) {
        this(latitude, longitude);

        assert classInvariants();
        assert isValidDouble(radius);

        this.radius = radius;

        assert classInvariants();
    }


    double getLatitude() {
        return latitude;
    }

    double getLongitude() {
        return longitude;
    }

    public double getRadius() {
        return radius;
    }

    /**
     * converts a spherical coordinate to a cartesian coordinate
     * transform spheric coordinate https://de.wikipedia.org/wiki/Kugelkoordinaten
     * @return CartesianCoordinate
     */
    public CartesianCoordinate convertToCartesianCoordinate(){
        assert classInvariants();

        assert isValidDouble(getLatitude());
        assert isValidDouble(getLongitude());
        assert isValidSphericRange();

        double theta = Math.toRadians(getLatitude());
        double phi = Math.toRadians(getLongitude());

        double x = EARTH_RADIUS_KM * Math.sin(theta) * Math.cos(phi);
        double y = EARTH_RADIUS_KM * Math.sin(theta) * Math.sin(phi);
        double z = EARTH_RADIUS_KM * Math.cos(theta);

        assert isValidDouble(x);
        assert isValidDouble(y);
        assert isValidDouble(z);

        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);

        assert classInvariants();
        return cartesianCoordinate;
    }


    /**
     * specific class invariant for spheric coordinate considering borders of lat, long and radius
     * @return boolean
     */
    public boolean classInvariants() {

        return isValidDouble(latitude) && isValidDouble(longitude) && isValidDouble(radius) && isValidRadius() && isValidSphericRange() && super.classInvariants();
    }

    /**
     * checks if the radius is valid
     * @return boolean
     */
    private boolean isValidRadius(){
        if(radius >= 0){
            return true;
        } else {
            throw new IllegalArgumentException("Radius must be not negative.");
        }
    }

    /**
     * checks ranges of the field variables
     * @return boolean
     */
    private boolean isValidSphericRange(){
        if (latitude > 90 || latitude < -90 || longitude > 180 || longitude < -180) {
            throw new IllegalArgumentException("coordinate is out of range.");
        } else {
            return true;
        }
    }

}
