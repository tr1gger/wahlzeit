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


    /**
     * @param coordinate coordinate on earth consisting of x, y and z
     * @return double
     */
    @Override
    public double getDistance(CartesianCoordinate coordinate) {

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

        return Math.sqrt(deltaX*deltaX + deltaY*deltaY + deltaZ*deltaZ);
    }
}
