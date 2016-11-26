package org.wahlzeit.model;

import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate {

    private double x;
    private double y;
    private double z;

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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }


    public void visit(Visitor v) {
        v.visit(this);
    }

    /**
     * @param coordinate coordinate on earth consisting of x, y and z
     * @return double
     */
    public double doGetDistance(CartesianCoordinate coordinate) {

        /**
         * Euclidean distance
         * further information https://en.wikipedia.org/wiki/Euclidean_distance
         */
        double x = coordinate.getX();
        double y = coordinate.getY();
        double z = coordinate.getZ();

        double deltaX = this.x - x;
        double deltaY = this.y - y;
        double deltaZ = this.z - z;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }


    SphericCoordinate convert() {

        /**
         * transformation of cartesian coordinates into spherical
         * further information http://www.mathepedia.de/Kugelkoordinaten.aspx
         */
        double x = getX();
        double y = getY();
        double z = getZ();

        if (x == 0 && y == 0) {
            throw new IllegalArgumentException("x and y must be not 0!");
        }

        double radius = Math.sqrt(x * x + y * y + z * z);
        double delta = SphericCoordinate.EARTH_RADIUS_KM - radius;

        if (Math.abs(delta) > 10E-2) {
            throw new IllegalArgumentException("cartesian coordinates should be on earth! Your Radius is " + radius + " KM");
        }

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


        return new SphericCoordinate(Math.toDegrees(lambda), Math.toDegrees(phi));
    }

    @Override
    public double getDistance(AbstractCoordinate coordinate) {
        Visitor visitor = new Visitor() {

            double distance;

            @Override
            public double getDistance() {
                return distance;
            }

            @Override
            public boolean isEqual() {
                return false;
            }

            @Override
            public void visit(CartesianCoordinate cartesianCoordinate) {
                distance = doGetDistance(cartesianCoordinate);
            }

            @Override
            public void visit(SphericCoordinate sphericCoordinate) {
                CartesianCoordinate cartesianCoordinate = sphericCoordinate.convert();
                distance = doGetDistance(cartesianCoordinate);
            }
        };

        coordinate.visit(visitor);
        return visitor.getDistance();
    }

    private boolean doIsEqual(CartesianCoordinate cartesianCoordinate) {

            if (this == cartesianCoordinate)
                return true;

            if (cartesianCoordinate == null)
                return false;

            if (getClass() != cartesianCoordinate.getClass())
                return false;

            return Objects.equals(x, cartesianCoordinate.x)
                    && Objects.equals(y, cartesianCoordinate.y)
                    && Objects.equals(z, cartesianCoordinate.z);
    }

    @Override
    public boolean isEqual(AbstractCoordinate coordinate) {

        Visitor visitor = new Visitor() {

            boolean isEqual;

            @Override
            public double getDistance() {
                return 0;
            }

            @Override
            public boolean isEqual() {
                return isEqual;
            }

            @Override
            public void visit(CartesianCoordinate cartesianCoordinate) {
                isEqual = doIsEqual(cartesianCoordinate);
            }

            @Override
            public void visit(SphericCoordinate sphericCoordinate) {
                isEqual = false;

            }
        };

        coordinate.visit(visitor);
        return visitor.isEqual();
    }
}
