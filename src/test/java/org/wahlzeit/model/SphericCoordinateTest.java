package org.wahlzeit.model;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SphericCoordinateTest {

    double epsilon = 1E-4;

    double berlinTokyo = 7959.4152d;

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
        assertEquals(berlinTokyo, berlin.getDistance(tokyo), epsilon);
        assertEquals(berlinTokyo, tokyo.getDistance(berlin), epsilon);
        assertEquals(0, tokyo.getDistance(tokyo), epsilon);
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
