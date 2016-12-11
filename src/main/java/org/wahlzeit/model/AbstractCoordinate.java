package org.wahlzeit.model;
import org.wahlzeit.Exceptions.InvalidCoordinateException;
import org.wahlzeit.Exceptions.InvalidDoubleException;

import java.util.Objects;
import java.util.logging.Logger;

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
    public boolean isEqual(AbstractCoordinate coordinate) {
        if (this == coordinate)
            return true;

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
    public double getDistance(AbstractCoordinate coordinate) throws InvalidCoordinateException, InvalidDoubleException {
        classInvariants();
        isNotNullCoordinate(coordinate);
        isValidCoordinate(coordinate);

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

        double result = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);

        classInvariants();
        return result;
    }

    /**
     * checks if coordinate is null
     * @param coordinate abstract coordinate
     * @return boolean
     */
    protected boolean isNotNullCoordinate(AbstractCoordinate coordinate) {
        if(coordinate != null){
            return true;
        } else {
            throw new IllegalArgumentException("Coordinate must not be null");
        }
    }

    /**
     * checks if the coordinate is valid
     * @param coordinate abstract coordinate
     * @return boolean
     */
    protected boolean isValidCoordinate(AbstractCoordinate coordinate) throws InvalidCoordinateException {
        try {
            if(isValidDouble(coordinate.getX()) && isValidDouble(coordinate.getY()) && isValidDouble(coordinate.getZ())){
                return true;
            } else {
                throw new InvalidCoordinateException("Coordinate is not valid");
            }
        } catch (InvalidDoubleException e) {
            log.warning(e.getMessage());
        }
        return false;
    }

    /**
     * check if the parameter is a finite double value and a number
     * @param val double value
     * @return boolean
     */
    protected boolean isValidDouble(double val) throws InvalidDoubleException{
        if (!Double.isInfinite(val) && !Double.isNaN(val))
            return true;
        else
           throw new InvalidDoubleException();
    }

    /**
     * condition which muss be full-filled at all time
     * @return boolean
     */
    protected boolean classInvariants() throws InvalidCoordinateException {
        if(isValidCoordinate(this)){
            return true;
        } else {
            throw new IllegalStateException("AbstractCoordinate invariants are not satisfied");
        }
    }
}

