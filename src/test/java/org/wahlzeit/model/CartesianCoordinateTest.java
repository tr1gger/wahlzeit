package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.Exceptions.InvalidCoordinateException;

import static org.junit.Assert.*;

public class CartesianCoordinateTest {

    double EPSILON = 1E-4;

    Coordinate cartesianCoordinateA;
    Coordinate cartesianCoordinateB;
    Coordinate cartesianCoordinateC;
    Coordinate sphericCoordinate;

    @Before
    public void setUp() throws InvalidCoordinateException {

        cartesianCoordinateA = CartesianCoordinate.getInstance(0, 0, 0);
        cartesianCoordinateB = CartesianCoordinate.getInstance(10, 10, 10);
        sphericCoordinate = SphericCoordinate.getInstance(10, 10, 10);

        double x = sphericCoordinate.getX();
        double y = sphericCoordinate.getY();
        double z = sphericCoordinate.getZ();

        cartesianCoordinateC = CartesianCoordinate.getInstance(x, y, z);
    }

    @Test
    public void testConstructor() {
        assertEquals(10, cartesianCoordinateB.getX(), 0);
        assertEquals(10, cartesianCoordinateB.getY(), 0);
        assertEquals(10, cartesianCoordinateB.getZ(), 0);
    }


    @Test
    public void testIsEqual() throws InvalidCoordinateException {
        assertFalse(cartesianCoordinateA.isEqual(cartesianCoordinateB));
        assertFalse(cartesianCoordinateB.isEqual(cartesianCoordinateA));
        assertTrue(cartesianCoordinateA.isEqual(cartesianCoordinateA));
    }

    @Test
    public void testIsEqualSphericCoordinate() throws InvalidCoordinateException {
        assertFalse(cartesianCoordinateA.isEqual(sphericCoordinate));
        assertFalse(sphericCoordinate.isEqual(cartesianCoordinateA));
    }

    @Test
    public void testGetDistance() throws InvalidCoordinateException {
        assertEquals(17.3205, cartesianCoordinateA.getDistance(cartesianCoordinateB), EPSILON);
    }

    @Test
    public void testLatitude(){
        assertEquals(sphericCoordinate.getLongitude(), cartesianCoordinateC.getLongitude(), EPSILON);
    }

    @Test
    public void testLongitude(){
        assertEquals(sphericCoordinate.getLatitude(), cartesianCoordinateC.getLatitude(), EPSILON);
    }

    @Test
    public void testRadius(){
        assertEquals(sphericCoordinate.getRadius(), cartesianCoordinateC.getRadius(), EPSILON);
    }

}
