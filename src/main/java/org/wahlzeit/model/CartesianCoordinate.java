package org.wahlzeit.model;
import java.util.Map;

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

    /**
     * gets a coordinate as a map
     * @return Map
     */
    @Override
    public Map<String, Double> getCoordinates() {
        coordinates.put("x", x);
        coordinates.put("y", y);
        coordinates.put("z", z);

        return coordinates;
    }

    /**
     * calculates the shortest distance between two coordinates
     * @param coordinate abstract coordinate
     * @return double
     */
    @Override
    public double getDistance(AbstractCoordinate coordinate) {
        return super.doGetDistance(coordinate);
    }

    /**
     * checks if two coordinates are equal
     * @param coordinate abstract coordinate
     * @return boolean
     */
    @Override
    public boolean isEqual(AbstractCoordinate coordinate) {
        return super.doIsEqual(coordinate);
    }


    /**
     * converts a cartesian coordinate to a spherical coordinate
     * @return SphericCoordinate
     */
    public SphericCoordinate convert() {

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

}
