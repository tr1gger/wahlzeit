package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.Exceptions.InvalidCoordinateException;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {

    private static final Logger log = Logger.getLogger(CoordinateTest.class.getName());

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

        try {
            sphericCoordinate = new SphericCoordinate(lat, lng);
            transformedSphericCoordinate = sphericCoordinate.convertToCartesianCoordinate();
        } catch (InvalidCoordinateException e) {
            log.warning(e.getMessage());
        }
    }


    @Test
    public void testTransformSphericCoordinate(){

        try {
            assertEquals(x, transformedCartesianCoordinate.convertToCartesianCoordinate().getX(), 10E-2);
            assertEquals(z, transformedCartesianCoordinate.convertToCartesianCoordinate().getZ(), 10E-2);
            assertEquals(y, transformedCartesianCoordinate.convertToCartesianCoordinate().getY(), 10E-2);
        } catch (InvalidCoordinateException e) {
            log.warning(e.getMessage());
        }
    }
}
