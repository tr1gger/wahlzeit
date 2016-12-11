package org.wahlzeit.model;


import org.wahlzeit.Exceptions.InvalidCoordinateException;
import org.wahlzeit.Exceptions.InvalidDoubleException;

public interface Coordinate {

    double getDistance(AbstractCoordinate coordinate) throws InvalidDoubleException, InvalidCoordinateException;
    boolean isEqual(AbstractCoordinate coordinate);
}
