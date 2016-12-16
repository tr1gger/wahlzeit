package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.Exceptions.InvalidCoordinateException;

import static org.junit.Assert.*;

public class CartesianCoordinateTest {


    CartesianCoordinate cartesianCoordinateA;
    CartesianCoordinate cartesianCoordinateB;
    SphericCoordinate sphericCoordinate;

    @Test
    public void testConstructor(){
        assertEquals(10, cartesianCoordinateB.getX(), 0);
        assertEquals(10, cartesianCoordinateB.getY(), 0);
        assertEquals(10, cartesianCoordinateB.getZ(), 0);
    }


    @Before
    public void setUp(){
        try {
            cartesianCoordinateA = new CartesianCoordinate(0, 0, 0);
            cartesianCoordinateB = new CartesianCoordinate(10, 10, 10);
            sphericCoordinate = new SphericCoordinate(10, 10);
        } catch (InvalidCoordinateException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testIsEqual(){
        assertFalse(cartesianCoordinateA.isEqual(cartesianCoordinateB));
        assertFalse(cartesianCoordinateB.isEqual(cartesianCoordinateA));
        assertTrue(cartesianCoordinateA.isEqual(cartesianCoordinateA));
    }

    @Test
    public void testIsEqualSphericCoordinate(){
        assertFalse(cartesianCoordinateA.isEqual(sphericCoordinate));
        assertFalse(sphericCoordinate.isEqual(cartesianCoordinateA));
    }

    @Test
    public void testGetDistance(){
        try {
            assertEquals(17.3205, cartesianCoordinateA.getDistance(cartesianCoordinateB), 10E-4);
        } catch (InvalidCoordinateException e) {
            e.printStackTrace();
        }
    }

}
