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
        assert classInvariants();

        this.x = x;
        this.y = y;
        this.z = z;

        assert classInvariants();
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }


    /**
     * converts a cartesian coordinate to a spherical coordinate
     * @return SphericCoordinate
     */
    public SphericCoordinate convertToSphericCoordinate()throws InvalidCoordinateException {
        assert classInvariants();

        /**
         * transformation of cartesian coordinates into spherical
         * further information http://www.mathepedia.de/Kugelkoordinaten.aspx
         */
        double x = getX();
        double y = getY();
        double z = getZ();

        assert x != 0 && y != 0 : "x and y must be not null to convertToSphericCoordinate to spheric coordinate";

        double phi;
        double argPhi = x / (Math.sqrt(x * x + y * y));
        double acos = Math.acos(argPhi);

        if (y >= 0) {
            phi = acos;
        } else {
            phi = 2 * Math.PI - acos;
        }

        double argTan = z / Math.sqrt(x * x + y * y);
        double lambda = Math.PI / 2 - Math.atan(argTan);

        SphericCoordinate sphericCoordinate = new SphericCoordinate(Math.toDegrees(lambda), Math.toDegrees(phi));

        assert classInvariants();
        return sphericCoordinate;
    }

}
