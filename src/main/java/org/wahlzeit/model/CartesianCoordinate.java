package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

    /**
     * @param x in KM
     * @param y in KM
     * @param z in KM
     */
    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * calculates the shortest distance between two coordinates
     * @param coordinate abstract coordinate
     * @return double
     */
    @Override
    public double getDistance(AbstractCoordinate coordinate) {
        assert classInvariants();
        assert isNotNullCoordinate(coordinate);
        assert isValidCoordinate(coordinate);

        double distance = super.getDistance(coordinate);

        assert isValidDouble(distance);
        assert classInvariants();

        return distance;
    }


    /**
     * converts a cartesian coordinate to a spherical coordinate
     * @return SphericCoordinate
     */
    public SphericCoordinate convertToSphericCoordinate() {
        assert classInvariants();

        /**
         * transformation of cartesian coordinates into spherical
         * further information http://www.mathepedia.de/Kugelkoordinaten.aspx
         */
        double x = getX();
        double y = getY();
        double z = getZ();

        assert isValidDouble(x);
        assert isValidDouble(y);
        assert isValidDouble(z);
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

        assert isValidDouble(lambda);
        assert isValidDouble(phi);

        SphericCoordinate sphericCoordinate = new SphericCoordinate(Math.toDegrees(lambda), Math.toDegrees(phi));

        assert classInvariants();
        return sphericCoordinate;
    }

}
