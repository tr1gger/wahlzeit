package org.wahlzeit.model;

/**
 * Class that represents a location
 */
public class Location {

    private Coordinate coordinate;

    public Location(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
