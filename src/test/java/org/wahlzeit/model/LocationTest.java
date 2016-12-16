package org.wahlzeit.model;

import org.junit.Test;
import org.wahlzeit.Exceptions.InvalidCoordinateException;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for Location Class
 */
public class LocationTest {

    double lat = 52.51;
    double lng = 13.40;

    @Test
    public void testConstructor(){

        SphericCoordinate berlin = null;
        try {
            berlin = new SphericCoordinate(lat , lng);
        } catch (InvalidCoordinateException e) {
            e.printStackTrace();
        }
        Location location = new Location(berlin);

        SphericCoordinate coordinate = (SphericCoordinate) location.getCoordinate();
        assertEquals(lat, coordinate.getLatitude(), 10E-10);
        assertEquals(lng, coordinate.getLongitude(), 10E-10);
    }
}
