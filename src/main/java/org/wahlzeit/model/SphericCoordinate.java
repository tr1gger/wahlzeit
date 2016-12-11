package org.wahlzeit.model;

import org.wahlzeit.Exceptions.InvalidCoordinateException;
import org.wahlzeit.Exceptions.InvalidDoubleException;
import org.wahlzeit.Exceptions.InvalidSphericRangeException;

import java.util.logging.Logger;

/**
 * class represents SphericCoordinate on earth
 */
public class SphericCoordinate extends AbstractCoordinate {

    private static final Logger log = Logger.getLogger(SphericCoordinate.class.getName());

    static final double EARTH_RADIUS_KM = 6371;

    private double latitude;
    private double longitude;
    private double radius = EARTH_RADIUS_KM;

    /**
     * latitude must be between -90 and 90 && longitude must be between -180 and 180 degree
     *
     * @param latitude  latitude > 0 north, latitude < 0 south
     * @param longitude longitude > 0 east, longitude < 0 west
     */
    public SphericCoordinate(double latitude, double longitude) throws InvalidCoordinateException {
        classInvariants();

        this.latitude = latitude;
        this.longitude = longitude;

        classInvariants();
    }

    /**
     * constructor for spheric coordinates and variable radius
     * @param latitude  latitude > 0 north, latitude < 0 south
     * @param longitude longitude > 0 east, longitude < 0 west
     * @param radius radius >= 0
     */
    public SphericCoordinate(double latitude, double longitude, double radius) throws InvalidCoordinateException {
        this(latitude, longitude);
        classInvariants();

        this.radius = radius;

        classInvariants();
    }

    @Override
    double getX() {
        return  EARTH_RADIUS_KM * Math.sin(Math.toRadians(getLatitude())) * Math.cos(Math.toRadians(getLongitude()));
    }

    @Override
    double getY() {
        return  EARTH_RADIUS_KM * Math.sin(Math.toRadians(getLatitude())) * Math.sin(Math.toRadians(getLongitude()));
    }

    @Override
    double getZ() {
        return EARTH_RADIUS_KM * Math.cos(Math.toRadians(getLatitude()));
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
    public CartesianCoordinate convertToCartesianCoordinate() throws InvalidCoordinateException {
        classInvariants();

        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(getX(), getY(), getZ());

        classInvariants();
        return cartesianCoordinate;
    }


    /**
     * specific class invariant for spheric coordinate considering borders of lat, long and radius
     * @return boolean
     */
    public boolean classInvariants() throws InvalidCoordinateException {
        try {
            return isValidDouble(latitude) && isValidDouble(longitude) && isValidDouble(radius) && isValidRadius() && isValidSphericRange() && super.classInvariants();
        } catch (InvalidDoubleException e) {
            log.warning(e.getMessage());
        } catch (InvalidSphericRangeException e) {
            log.warning(e.getMessage());
        }
        throw new InvalidCoordinateException("Not a valid coordinate, check your parameters");
    }

    /**
     * checks if the radius is valid
     * @return boolean
     */
    private boolean isValidRadius() throws IllegalArgumentException{
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
    private boolean isValidSphericRange() throws InvalidSphericRangeException {
        if (latitude > 90 || latitude < -90 || longitude > 180 || longitude < -180) {
            throw new InvalidSphericRangeException("coordinate is out of range.");
        } else {
            return true;
        }
    }

}
