package org.wahlzeit.model;

import org.wahlzeit.Exceptions.InvalidCoordinateException;

public interface Coordinate {

    double getDistance(AbstractCoordinate coordinate) throws InvalidCoordinateException;
    boolean isEqual(AbstractCoordinate coordinate) throws InvalidCoordinateException;
}
