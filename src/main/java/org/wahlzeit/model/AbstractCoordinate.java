package org.wahlzeit.model;

import org.wahlzeit.Exceptions.InvalidCoordinateException;
import org.wahlzeit.Exceptions.InvalidDoubleException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.wahlzeit.utils.Asserts.assertNotNull;
import static org.wahlzeit.utils.Asserts.assertValidDouble;

abstract class AbstractCoordinate implements Coordinate {

    /**
     *
     */
    private static final Logger log = Logger.getLogger(AbstractCoordinate.class.getName());

    /**
     *
     */
    public static Map<Integer, Coordinate> sharedCoordinate = new HashMap<>();

    /**
     * @methodtype compare
     * @param coordinate coordinate
     * @return boolean
     */
    @Override
    public boolean isEqual(Coordinate coordinate) throws InvalidCoordinateException {
        assertNotNull(coordinate);
        assertValidCoordinate(coordinate);

        return this == coordinate;
    }


    /**
     * @methodtype get
     * @param coordinate coordinate on earth consisting of x, y and z
     * @return double
     */
    @Override
    public double getDistance(Coordinate coordinate) throws InvalidCoordinateException {
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
     * @methodtype assertion
     * @param coordinate abstract coordinate
     */
    protected void assertValidCoordinate(Coordinate coordinate) throws InvalidCoordinateException {
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
     * returns argument only if this value object has not already been initialized
     * otherwise the shared object will be returned
     *
     * @methodtype get
     * @return Coordinate
     */
    public static Coordinate getInstance(Coordinate coordinate) throws InvalidCoordinateException {
        int key = coordinate.hashCode();
        Coordinate result = sharedCoordinate.get(key);

        if(result == null){
            sharedCoordinate.put(key, coordinate);
            return coordinate;
        } else {
            return result;
        }
    }

    /**
     * condition which muss be full-filled at all time
     * @methodtype assertion
     */
    protected void classInvariants() throws InvalidCoordinateException {
        assertValidCoordinate(this);
    }

    /**
     * creates a String representation of a coordinate object
     * @return String
     */
    public String asString(){
        return getX() + "-" + getY() + "-" + getZ() + "-" + getLatitude() + "-" + getLongitude() + "-" + getRadius();
    }

    /**
     * uses the string representation to create a unique hash value
     * @return int
     */
    @Override
    public int hashCode() {
        return asString().hashCode();
    }
}

