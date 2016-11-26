package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CartesianCoordinateTest {


    CartesianCoordinate cartesianCoordinateA;
    CartesianCoordinate cartesianCoordinateB;

    @Test
    public void testConstructor(){
        assertEquals(10, cartesianCoordinateB.getX(), 0);
        assertEquals(10, cartesianCoordinateB.getY(), 0);
        assertEquals(10, cartesianCoordinateB.getZ(), 0);
    }


    @Before
    public void setUp(){
        cartesianCoordinateA = new CartesianCoordinate(0, 0, 0);
        cartesianCoordinateB = new CartesianCoordinate(10, 10, 10);
    }

    @Test
    public void testGetDistance(){
        assertEquals(17.3205, cartesianCoordinateA.getDistance(cartesianCoordinateB), 10E-4);
    }

}
