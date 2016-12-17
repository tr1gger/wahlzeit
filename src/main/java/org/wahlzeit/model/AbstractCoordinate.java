package org.wahlzeit.model;

import org.wahlzeit.Exceptions.InvalidCoordinateException;
import org.wahlzeit.Exceptions.InvalidDoubleException;

import java.util.Objects;
import java.util.logging.Logger;

import static org.wahlzeit.utils.Asserts.assertNotNull;
import static org.wahlzeit.utils.Asserts.assertValidDouble;

abstract class AbstractCoordinate implements Coordinate {

    private static final Logger log = Logger.getLogger(AbstractCoordinate.class.getName());

    abstract double getX();

    abstract double getY();

    abstract double getZ();

    /**
     * checks if two coordinates are equal
     *
     * @param coordinate abstract coordiante
     * @return boolean
     */
    @Override
    public boolean isEqual(AbstractCoordinate coordinate) throws InvalidCoordinateException {
        assertNotNull(coordinate);
        assertValidCoordinate(coordinate);

        if (this == coordinate) {
            return true;
        }

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
    @Override
    public double getDistance(AbstractCoordinate coordinate) throws InvalidCoordinateException {
        assertNotNull(coordinate);
        assertValidCoordinate(coordinate);

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

        return  Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }

    /**
     * checks if the coordinate is valid
     * @param coordinate abstract coordinate
     */
    protected void assertValidCoordinate(AbstractCoordinate coordinate) throws InvalidCoordinateException {
        assertNotNull(coordinate);

        try {
            assertValidDouble(coordinate.getX());
            assertValidDouble(coordinate.getY());
            assertValidDouble(coordinate.getZ());
        } catch (InvalidDoubleException e) {
            log.warning(e.getMessage());
            throw new InvalidCoordinateException("Coordinate is not valid");
        }
    }


    /**
     * condition which muss be full-filled at all time
     */
    protected void classInvariants() throws InvalidCoordinateException {
        assertValidCoordinate(this);
    }
}

