package org.wahlzeit.model;

import org.wahlzeit.Exceptions.InvalidCoordinateException;

public class CartesianCoordinate extends AbstractCoordinate {

    private final double x;
    private final double y;
    private final double z;

    /**
     * @param x in KM
     * @param y in KM
     * @param z in KM
     */
    private CartesianCoordinate(double x, double y, double z) throws InvalidCoordinateException {
        classInvariants();

        this.x = x;
        this.y = y;
        this.z = z;

        classInvariants();
    }

    public static Coordinate getInstance(double x, double y, double z) throws InvalidCoordinateException {
        Coordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);
        return getInstance(cartesianCoordinate);
    }

    /**
     * @methodtype get
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * @methodtype get
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * @methodtype get
     */
    @Override
    public double getZ() {
        return z;
    }

    /**
     * @methodtype get
     */
    @Override
    public double getLatitude() {

        return Math.toDegrees(Math.atan2(Math.sqrt(x*x+y*y), z ));
    }

    /**
     * @methodtype get
     */
    @Override
    public double getLongitude() {
        return Math.toDegrees(Math.atan2(y, x));
    }

    /**
     * @methodtype get
     */
    @Override
    public double getRadius()
    {
        return Math.sqrt(x*x+y*y+z*z);
    }

}
