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
    public void testConstructor() throws InvalidCoordinateException{

        Coordinate berlin = SphericCoordinate.getInstance(lat , lng, SphericCoordinate.EARTH_RADIUS_KM);
        Location location = new Location(berlin);
        SphericCoordinate coordinate = (SphericCoordinate) location.getCoordinate();

        assertEquals(lat, coordinate.getLatitude(), 10E-10);
        assertEquals(lng, coordinate.getLongitude(), 10E-10);
    }

}
