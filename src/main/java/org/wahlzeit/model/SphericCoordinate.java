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

    private final double latitude;
    private final double longitude;
    private final double radius;

    /**
     * latitude must be between -90 and 90 && longitude must be between -180 and 180 degree
     * @param latitude  latitude > 0 north, latitude < 0 south
     * @param longitude longitude > 0 east, longitude < 0 west
     * @param radius
     */
    private SphericCoordinate(double latitude, double longitude, double radius) throws InvalidCoordinateException {
        assertClassInvariants();

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;

        assertClassInvariants();
    }

    public static Coordinate getInstance(double latitude, double longitude, double radius) throws InvalidCoordinateException {
        Coordinate sphericCoordinate = new SphericCoordinate(latitude, longitude, radius);
        return getInstance(sphericCoordinate);
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
        if (radius < 0) {
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
    public double getX() {
        return radius * Math.sin(Math.toRadians(latitude)) * Math.cos(Math.toRadians(longitude));
    }

    /**
     * @methodtype get
     */
    @Override
    public double getY() {
        return radius * Math.sin(Math.toRadians(latitude)) * Math.sin(Math.toRadians(longitude));
    }

    /**
     * @methodtype get
     */
    @Override
    public double getZ() {
        return radius * Math.cos(Math.toRadians(latitude));
    }

    /**
     * @methodtype get
     */
    @Override
    public double getLatitude() {
        return latitude;
    }

    /**
     * @methodtype get
     */
    @Override
    public double getLongitude() {
        return longitude;
    }

    /**
     * @methodtype get
     */
    @Override
    public double getRadius() {
        return radius;
    }
}
