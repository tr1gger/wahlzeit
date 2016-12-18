package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.Exceptions.InvalidCoordinateException;

import static org.junit.Assert.assertEquals;

/**
 * Test the Value Object criteria for coordinate object
 */
public class CoordinateValueObjectTest {

    Coordinate cartesianCoordinateA;
    Coordinate cartesianCoordinateB;
    Coordinate cartesianCoordinateC;

    Coordinate sphericCoordinateA;
    Coordinate sphericCoordinateB;
    Coordinate sphericCoordinateC;

    int numbersOfValueObjects = 4;

    @Before
    public void setUp() throws InvalidCoordinateException {

        AbstractCoordinate.sharedCoordinate.clear();

        cartesianCoordinateA = CartesianCoordinate.getInstance(0, 0, 0);
        cartesianCoordinateB = CartesianCoordinate.getInstance(0, 0, 0);
        cartesianCoordinateC = CartesianCoordinate.getInstance(10, 10, 10);

        sphericCoordinateA =  SphericCoordinate.getInstance(0, 0, SphericCoordinate.EARTH_RADIUS_KM);
        sphericCoordinateB =  SphericCoordinate.getInstance(0, 0, SphericCoordinate.EARTH_RADIUS_KM);
        sphericCoordinateC = SphericCoordinate.getInstance(10, 10, 0);
    }

    @Test
    public void testSharedCoordinates(){
        assertEquals(numbersOfValueObjects, AbstractCoordinate.sharedCoordinate.size());
    }

}
