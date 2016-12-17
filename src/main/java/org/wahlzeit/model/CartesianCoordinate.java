package org.wahlzeit.model;

import org.wahlzeit.Exceptions.InvalidCoordinateException;

public class CartesianCoordinate extends AbstractCoordinate {

    double x;
    double y;
    double z;

    /**
     * @param x in KM
     * @param y in KM
     * @param z in KM
     */
    public CartesianCoordinate(double x, double y, double z) throws InvalidCoordinateException {
        classInvariants();

        this.x = x;
        this.y = y;
        this.z = z;

        classInvariants();
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

}
