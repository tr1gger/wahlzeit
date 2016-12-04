package org.wahlzeit.model;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SphericCoordinateTest {

    double berlinTokyoDistance = 8918.95;
    double epsilon = 1E-4;

    SphericCoordinate berlin;
    SphericCoordinate tokyo;
    SphericCoordinate center;

    CartesianCoordinate cartesianCoordinate;

    @Before
    public void setUp(){
        berlin = new SphericCoordinate(52.517 , 13.40);
        tokyo = new SphericCoordinate(35.70 , 139.767);

        /**
         * Spheric Coordinate with radius 0
         */
        center = new SphericCoordinate(0, 0, 0);

        cartesianCoordinate = new CartesianCoordinate(10, 10, 10);
    }

    @Test
    public void testEarthRadius(){
        assertEquals(6371, SphericCoordinate.EARTH_RADIUS_KM, 1E-10);
    }

    @Test
    public void testConstructor(){

        double lat = 0;
        double lng = 90;
        double radius = 0;

        SphericCoordinate sphericCoordinate = new SphericCoordinate(lat, lng);
        assertEquals(lat, sphericCoordinate.getLatitude(), epsilon);
        assertEquals(lng, sphericCoordinate.getLongitude(), epsilon);

        SphericCoordinate centerCoordinate = new SphericCoordinate(lat, lng, radius);
        assertEquals(radius, centerCoordinate.getRadius(), epsilon);

    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorLatRange() {

        double lat = 91;
        double lng = 0;

        new SphericCoordinate(lat, lng);
    }


    @Test(expected=IllegalArgumentException.class)
    public void testConstructorLngRange() {

        double lat = 0;
        double lng = 181;

        new SphericCoordinate(lat, lng);
    }

    @Test
    public void testGetDistance(){

        SphericCoordinate northPole = new SphericCoordinate(0, 90);
        SphericCoordinate southPole = new SphericCoordinate(0, -90);

        /**
         * distance between berlin and tokyo
         */
        assertEquals(berlinTokyoDistance, berlin.getDistance(tokyo), epsilon);
        assertEquals(tokyo.getDistance(berlin), berlin.getDistance(tokyo), 0);

        /**
         * meridian by distance between north and south pole
         */
        assertEquals(SphericCoordinate.EARTH_RADIUS_KM * Math.PI, northPole.getDistance(southPole), 0);

        /**
         * earth radius by distance between north and south pole
         */
        assertEquals(SphericCoordinate.EARTH_RADIUS_KM, southPole.getDistance(northPole) / (Math.PI), 0);
    }

    @Test
    public void testIsEqual(){
        assertTrue(berlin.isEqual(berlin));
        assertFalse(berlin.isEqual(tokyo));
        assertFalse(tokyo.isEqual(berlin));
    }

    @Test
    public void testIsEqualCartesianCoordinate(){
        assertFalse(berlin.isEqual(cartesianCoordinate));
        assertFalse(cartesianCoordinate.isEqual(berlin));
    }
}
