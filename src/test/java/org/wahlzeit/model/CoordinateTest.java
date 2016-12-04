package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {

    SphericCoordinate sphericCoordinate;
    SphericCoordinate transformedCartesianCoordinate;

    CartesianCoordinate transformedSphericCoordinate;
    CartesianCoordinate cartesianCoordinate;

    double lat = 52.51;
    double lng = 13.40;

    double x = 4917.97;
    double y = 1171.62;
    double z = 3876.91;

    @Before
    public void setUp(){

        sphericCoordinate = new SphericCoordinate(lat, lng);
        transformedSphericCoordinate = sphericCoordinate.convertToCartesianCoordinate();

        cartesianCoordinate = new CartesianCoordinate(x, y, z);
        transformedCartesianCoordinate = cartesianCoordinate.convertToSphericCoordinate();
    }

    @Test
    public void testTransformCartesianCoordinate(){

        assertEquals(lat, transformedSphericCoordinate.convertToSphericCoordinate().getLatitude(), 10E-2);
        assertEquals(lng, transformedSphericCoordinate.convertToSphericCoordinate().getLongitude(), 10E-2);
    }

    @Test
    public void testTransformSphericCoordinate(){

        assertEquals(x, transformedCartesianCoordinate.convertToCartesianCoordinate().getX(), 10E-2);
        assertEquals(y, transformedCartesianCoordinate.convertToCartesianCoordinate().getY(), 10E-2);
        assertEquals(z, transformedCartesianCoordinate.convertToCartesianCoordinate().getZ(), 10E-2);
    }
}
