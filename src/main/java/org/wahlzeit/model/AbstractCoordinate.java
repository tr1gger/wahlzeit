package org.wahlzeit.model;
import java.util.Objects;

abstract class AbstractCoordinate implements Coordinate {

    double x;
    double y;
    double z;


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
     * checks if two coordinates are equal
     *
     * @param coordinate abstract coordiante
     * @return boolean
     */
    @Override
    public boolean isEqual(AbstractCoordinate coordinate) {
        assert classInvariants();

        assert isNotNullCoordinate(coordinate);
        assert isValidCoordinate(coordinate);

        if (this == coordinate)
            return true;

        if (getClass() != coordinate.getClass())
            return false;

        boolean isEqual = Objects.equals(getX(), coordinate.getX())
                && Objects.equals(getY(), coordinate.getY())
                && Objects.equals(getZ(), coordinate.getZ());

        assert isValidCoordinate(coordinate);
        assert classInvariants();

        return isEqual;
    }


    /**
     * @param coordinate coordinate on earth consisting of x, y and z
     * @return double
     */
    @Override
    public double getDistance(AbstractCoordinate coordinate) {
        assert classInvariants();
        assert isNotNullCoordinate(coordinate);

        /**
         * Euclidean distance
         * further information https://en.wikipedia.org/wiki/Euclidean_distance
         */
        double x = coordinate.getX();
        double y = coordinate.getY();
        double z = coordinate.getZ();

        assert isValidDouble(x);
        assert isValidDouble(y);
        assert isValidDouble(z);

        double deltaX = this.getX() - x;
        double deltaY = this.getY() - y;
        double deltaZ = this.getZ() - z;

        double result = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);

        assert isValidDouble(result);
        assert classInvariants();

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
    protected boolean isValidCoordinate(AbstractCoordinate coordinate){
        if(isValidDouble(coordinate.getX()) && isValidDouble(coordinate.getY()) && isValidDouble(coordinate.getZ())){
            return true;
        } else {
            throw new IllegalArgumentException("Coordinate is not valid");
        }
    }

    /**
     * check if the parameter is a finite double value and a number
     * @param val double value
     * @return boolean
     */
    protected boolean isValidDouble(double val){
        return !Double.isInfinite(val) && !Double.isNaN(val);
    }

    /**
     * condition which muss be full-filled at all time
     * @return boolean
     */
    protected boolean classInvariants(){
        if(isValidCoordinate(this)){
            return true;
        } else {
            throw new IllegalStateException("AbstractCoordinate invariants are not satisfied");
        }
    }
}

