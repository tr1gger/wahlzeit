package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateUtilTest {

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
        transformedSphericCoordinate = sphericCoordinate.convert();

        cartesianCoordinate = new CartesianCoordinate(x, y, z);
        transformedCartesianCoordinate = cartesianCoordinate.convert();
    }

    @Test
    public void testTransformCartesianCoordinate(){

        assertEquals(lat, transformedSphericCoordinate.convert().getLatitude(), 10E-2);
        assertEquals(lng, transformedSphericCoordinate.convert().getLongitude(), 10E-2);
    }

    @Test
    public void testTransformSphericCoordinate(){

        assertEquals(x, transformedCartesianCoordinate.convert().getX(), 10E-2);
        assertEquals(y, transformedCartesianCoordinate.convert().getY(), 10E-2);
        assertEquals(z, transformedCartesianCoordinate.convert().getZ(), 10E-2);
    }
}
