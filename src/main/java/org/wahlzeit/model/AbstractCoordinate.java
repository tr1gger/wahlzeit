package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

abstract class AbstractCoordinate implements Coordinate {

    Map<String, Double> coordinates = new HashMap<String, Double>();

    public abstract Map<String, Double> getCoordinates();

    public double getX() {
        return getCoordinates().get("x");
    }

    public double getY() {
        return getCoordinates().get("y");
    }

    public double getZ() {
        return getCoordinates().get("z");
    }

    /**
     * checks if two coordinates are equal
     * @param coordinate abstract coordiante
     * @return boolean
     */
    @Override
    public boolean isEqual(AbstractCoordinate coordinate) {
        return doIsEqual(coordinate);
    }


    /**
     * checks if two coordinates are equal
     * @param coordinate abstract coordinate
     * @return boolean
     */
    public boolean doIsEqual(AbstractCoordinate coordinate) {

        if (this == coordinate)
            return true;

        if (coordinate == null)
            return false;

        if (getClass() != coordinate.getClass())
            return false;

        return Objects.equals(getX(), coordinate.getX())
                && Objects.equals(getY(), coordinate.getY())
                && Objects.equals(getZ(), coordinate.getZ());
    }

    /**
     * @param coordinate coordinate on earth consisting of x, y and z
     * @return double
     */
    public double doGetDistance(AbstractCoordinate coordinate) {

        /**
         * Euclidean distance
         * further information https://en.wikipedia.org/wiki/Euclidean_distance
         */
        double x = coordinate.getX();
        double y = coordinate.getY();
        double z = coordinate.getZ();

        double deltaX = this.getX() - x;
        double deltaY = this.getY() - y;
        double deltaZ = this.getZ() - z;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }
}

