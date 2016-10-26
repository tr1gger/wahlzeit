package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for Location Class
 */
public class LocationTest {

    @Test
    public void testGetDistance(){
        /**
         * Berlin
         */
        Location berlin = new Location(new Coordinate(52.517 , 13.40));

        /**
         * Tokyo
         */
        Location tokyo = new Location(new Coordinate(35.70 , 139.767));

        /**
         * North Pole
         */
        Location northPole = new Location(new Coordinate(0, 90));

        /**
         * South Pole
         */
        Location southPole = new Location(new Coordinate(0, 270));

        assertEquals(8918.0, berlin.getDistance(tokyo), 5);
        assertEquals(tokyo.getDistance(berlin), berlin.getDistance(tokyo), 0);
        assertEquals(Coordinate.EARTH_RADIUS * Math.PI, northPole.getDistance(southPole), 0);
        assertEquals(southPole.getDistance(northPole), northPole.getDistance(southPole), 5);
        assertEquals(Coordinate.EARTH_RADIUS, southPole.getDistance(northPole) / (Math.PI), 0);
    }
}
