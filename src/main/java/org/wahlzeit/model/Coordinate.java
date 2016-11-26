package org.wahlzeit.model;


public interface Coordinate {

    double getDistance(AbstractCoordinate coordinate);

    boolean isEqual(AbstractCoordinate coordinate);

}
