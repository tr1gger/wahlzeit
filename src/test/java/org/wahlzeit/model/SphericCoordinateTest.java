package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.Exceptions.InvalidCoordinateException;

import static org.junit.Assert.*;

/**
 * Test spheric coordinate methods
 */
public class SphericCoordinateTest {

    double epsilon = 1E-4;

    double berlinTokyo = 7959.4152d;

    Coordinate berlin;
    Coordinate tokyo;
    Coordinate center;

    Coordinate cartesianCoordinate;

    @Before
    public void setUp() throws InvalidCoordinateException {

        tokyo = SphericCoordinate.getInstance(35.70, 139.767, SphericCoordinate.EARTH_RADIUS_KM);
        berlin = SphericCoordinate.getInstance(52.517, 13.40, SphericCoordinate.EARTH_RADIUS_KM);
        cartesianCoordinate = CartesianCoordinate.getInstance(10, 10, 10);
        center = SphericCoordinate.getInstance(0, 0, SphericCoordinate.EARTH_RADIUS_KM);
    }

    @Test
    public void testEarthRadius() {
        assertEquals(6371, SphericCoordinate.EARTH_RADIUS_KM, 1E-10);
    }

    @Test
    public void testConstructor() throws InvalidCoordinateException {

        double lat = 0;
        double lng = 90;
        double radius = 0;

        Coordinate sphericCoordinate = SphericCoordinate.getInstance(lat, lng, radius);

        assertEquals(lat, sphericCoordinate.getLatitude(), epsilon);
        assertEquals(lng, sphericCoordinate.getLongitude(), epsilon);
        assertEquals(radius, sphericCoordinate.getRadius(), epsilon);
    }

    @Test(expected = InvalidCoordinateException.class)
    public void testConstructorLatRange() throws InvalidCoordinateException {

        double lat = 91;
        double lng = 0;

        SphericCoordinate.getInstance(lat, lng, SphericCoordinate.EARTH_RADIUS_KM);
    }


    @Test(expected = InvalidCoordinateException.class)
    public void testConstructorLngRange() throws InvalidCoordinateException {

        double lat = 0;
        double lng = 181;

        SphericCoordinate.getInstance(lat, lng, SphericCoordinate.EARTH_RADIUS_KM);
    }

    @Test
    public void testGetDistance() throws InvalidCoordinateException {
        assertEquals(berlinTokyo, berlin.getDistance(tokyo), epsilon);
        assertEquals(berlinTokyo, tokyo.getDistance(berlin), epsilon);
        assertEquals(0, tokyo.getDistance(tokyo), epsilon);
    }

    @Test
    public void testIsEqual() throws InvalidCoordinateException {
        assertTrue(berlin.isEqual(berlin));
        assertFalse(berlin.isEqual(tokyo));
        assertFalse(tokyo.isEqual(berlin));
    }

    @Test
    public void testIsEqualCartesianCoordinate() throws InvalidCoordinateException {
        assertFalse(berlin.isEqual(cartesianCoordinate));
        assertFalse(cartesianCoordinate.isEqual(berlin));
    }
}
