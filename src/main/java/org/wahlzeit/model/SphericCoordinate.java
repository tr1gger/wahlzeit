package org.wahlzeit.model;

import org.wahlzeit.Exceptions.InvalidCoordinateException;
import org.wahlzeit.Exceptions.InvalidDoubleException;
import org.wahlzeit.Exceptions.InvalidSphericRangeException;

import java.util.logging.Logger;

import static org.wahlzeit.utils.Asserts.assertValidDouble;

/**
 * class represents SphericCoordinate on earth
 */
public class SphericCoordinate extends AbstractCoordinate {

    private static final Logger log = Logger.getLogger(SphericCoordinate.class.getName());

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
    public SphericCoordinate(double latitude, double longitude) throws InvalidCoordinateException {
        classInvariants();

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = EARTH_RADIUS_KM;
        classInvariants();
    }

    /**
     * constructor for spheric coordinates and variable radius
     *
     * @param latitude  latitude > 0 north, latitude < 0 south
     * @param longitude longitude > 0 east, longitude < 0 west
     * @param radius    radius >= 0
     */
    public SphericCoordinate(double latitude, double longitude, double radius) throws InvalidCoordinateException {
        this(latitude, longitude);
        assertClassInvariants();

        this.radius = radius;

        assertClassInvariants();
    }



    /**
     * @methodtype assert
     * specific class invariant for spheric coordinate considering borders of lat, long and radius
     */
    public void assertClassInvariants() throws InvalidCoordinateException {

        try {
            assertValidDouble(latitude);
            assertValidDouble(longitude);
            assertValidDouble(radius);

            assertValidRadius();
            assertValidSphericRange();

        } catch (InvalidDoubleException | InvalidSphericRangeException e) {
            log.warning(e.getMessage());
            throw new InvalidCoordinateException("Not a valid coordinate, check your parameters");
        }
    }

    /**
     *  @methodtype assert
     * checks if the radius is valid
     */
    private void assertValidRadius() throws IllegalArgumentException {
        if (radius >= 0) {
            throw new IllegalArgumentException("Radius must be not negative.");
        }
    }


    /**
     * @methodtype assert
     * checks ranges of the field variables
     */
    private void assertValidSphericRange() throws InvalidSphericRangeException {
        if (latitude > 90 || latitude < -90 || longitude > 180 || longitude < -180) {
            throw new InvalidSphericRangeException("coordinate is out of range.");
        }
    }

    /**
     * @methodtype get
     */
    @Override
    double getX() {
        return EARTH_RADIUS_KM * Math.sin(Math.toRadians(latitude)) * Math.cos(Math.toRadians(longitude));
    }

    /**
     * @methodtype get
     */
    @Override
    double getY() {
        return EARTH_RADIUS_KM * Math.sin(Math.toRadians(latitude)) * Math.sin(Math.toRadians(longitude));
    }

    /**
     * @methodtype get
     */
    @Override
    double getZ() {
        return EARTH_RADIUS_KM * Math.cos(Math.toRadians(latitude));
    }

    /**
     * @methodtype get
     */
    double getLatitude() {
        return latitude;
    }

    /**
     * @methodtype get
     */
    double getLongitude() {
        return longitude;
    }

    /**
     * @methodtype get
     */
    public double getRadius() {
        return radius;
    }
}
