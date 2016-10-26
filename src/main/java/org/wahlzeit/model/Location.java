package org.wahlzeit.model;

/**
 * Class that represents a location
 */
public class Location {

    public Coordinate coordinate;

    public Location(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public double getDistance(Location location) {
        return coordinate.getDistance(location.coordinate);
    }
}
