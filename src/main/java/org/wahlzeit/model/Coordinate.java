package org.wahlzeit.model;

import org.wahlzeit.Exceptions.InvalidCoordinateException;

public interface Coordinate {

    double getDistance(Coordinate coordinate) throws InvalidCoordinateException;

    boolean isEqual(Coordinate coordinate) throws InvalidCoordinateException;

    int hashCode();

    double getX();

    double getY();

    double getZ();

    double getLatitude();

    double getLongitude();

    double getRadius();
}
