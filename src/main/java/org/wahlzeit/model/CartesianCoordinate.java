package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate<CartesianCoordinate> {

    private double x;
    private double y;
    private double z;

    /**
     * @param x in KM
     * @param y in KM
     * @param z in KM
     */
    public CartesianCoordinate(double x, double y, double z){
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

    @Override
    public double getDistance(CartesianCoordinate coordinate) {

        /**
         * convert CartesianCoordinate to SphericCoordinate
         */
        SphericCoordinate otherSphericCoordinate = CoordinateUtil.transformCartesianCoordinate(coordinate);
        SphericCoordinate sphericCoordinate = CoordinateUtil.transformCartesianCoordinate(this);

        return CoordinateUtil.getDistance(sphericCoordinate, otherSphericCoordinate);
    }
}
