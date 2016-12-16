package org.wahlzeit.model;


import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.Exceptions.InvalidCoordinateException;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class SphericCoordinateTest {

    private static final Logger log = Logger.getLogger(SphericCoordinateTest.class.getName());

    double epsilon = 1E-4;

    double berlinTokyo = 7959.4152d;

    SphericCoordinate berlin;
    SphericCoordinate tokyo;
    SphericCoordinate center;

    CartesianCoordinate cartesianCoordinate;

    @Before
    public void setUp(){
        try {
            tokyo = new SphericCoordinate(35.70 , 139.767);
            berlin = new SphericCoordinate(52.517 , 13.40);
        } catch (InvalidCoordinateException e) {
            log.warning(e.getMessage());
        }

        /**
         * Spheric Coordinate with radius 0
         */
        try {
            cartesianCoordinate = new CartesianCoordinate(10, 10, 10);
            center = new SphericCoordinate(0, 0, 0);
        } catch (InvalidCoordinateException e) {
            log.warning(e.getMessage());
        }

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

        SphericCoordinate sphericCoordinate = null;
        try {
            sphericCoordinate = new SphericCoordinate(lat, lng);
        } catch (InvalidCoordinateException e) {
            log.warning(e.getMessage());
        }
        assertEquals(lat, sphericCoordinate.getLatitude(), epsilon);
        assertEquals(lng, sphericCoordinate.getLongitude(), epsilon);

        SphericCoordinate centerCoordinate = null;
        try {
            centerCoordinate = new SphericCoordinate(lat, lng, radius);
        } catch (InvalidCoordinateException e) {
            log.warning(e.getMessage());
        }
        assertEquals(radius, centerCoordinate.getRadius(), epsilon);

    }

    @Test(expected=InvalidCoordinateException.class)
    public void testConstructorLatRange() throws InvalidCoordinateException {

        double lat = 91;
        double lng = 0;

        new SphericCoordinate(lat, lng);
    }


    @Test(expected=InvalidCoordinateException.class)
    public void testConstructorLngRange() throws InvalidCoordinateException {

        double lat = 0;
        double lng = 181;

        new SphericCoordinate(lat, lng);
    }

    @Test
    public void testGetDistance(){
        try {
            assertEquals(berlinTokyo, berlin.getDistance(tokyo), epsilon);
            assertEquals(berlinTokyo, tokyo.getDistance(berlin), epsilon);
            assertEquals(0, tokyo.getDistance(tokyo), epsilon);
        } catch (InvalidCoordinateException e) {
            log.warning(e.getMessage());
        }

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
