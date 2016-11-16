package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for Location Class
 */
public class LocationTest {

    @Test
    public void testGetDistance(){

        Location berlin = new Location(new SphericCoordinate(52.517 , 13.40));

        Location tokyo = new Location(new SphericCoordinate(35.70 , 139.767));

        Location northPole = new Location(new SphericCoordinate(0, 90));

        Location southPole = new Location(new SphericCoordinate(0, -90));


        assertEquals(8918.0, berlin.getDistance(tokyo), 5);
        assertEquals(tokyo.getDistance(berlin), berlin.getDistance(tokyo), 0);
        assertEquals(SphericCoordinate.EARTH_RADIUS_KM * Math.PI, northPole.getDistance(southPole), 0);
        assertEquals(southPole.getDistance(northPole), northPole.getDistance(southPole), 5);
        assertEquals(SphericCoordinate.EARTH_RADIUS_KM, southPole.getDistance(northPole) / (Math.PI), 0);
    }

    @Test
    public void testCartesianGetDistance(){

        Location northPole = new Location(new CartesianCoordinate(0,0, SphericCoordinate.EARTH_RADIUS_KM));
        Location southPole = new Location(new CartesianCoordinate(0,0, -SphericCoordinate.EARTH_RADIUS_KM));

        System.out.println("Distance: " + northPole.getDistance(southPole));

    }
}
