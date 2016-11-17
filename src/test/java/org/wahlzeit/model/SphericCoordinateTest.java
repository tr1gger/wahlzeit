package org.wahlzeit.model;


import org.junit.Test;

import static org.junit.Assert.*;

public class SphericCoordinateTest {

    @Test
    public void testEarthRadius(){
        assertEquals(6371, SphericCoordinate.EARTH_RADIUS_KM, 1E-10);
    }

    @Test
    public void testConstructor(){

        double lat = 0;
        double lng = 90;

        SphericCoordinate sphericCoordinate = new SphericCoordinate(lat, lng);
        assertEquals(lat, sphericCoordinate.getLatitude(), 1E-10);
        assertEquals(lng, sphericCoordinate.getLongitude(), 1E-10);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorLatRange() {

        double lat = 91;
        double lng = 0;

        new SphericCoordinate(lat, lng);
    }


    @Test(expected=IllegalArgumentException.class)
    public void testConstructorLngRange() {

        double lat = 0;
        double lng = 181;

        new SphericCoordinate(lat, lng);
    }

    @Test
    public void testGetDistance(){

        SphericCoordinate berlin = new SphericCoordinate(52.517 , 13.40);
        SphericCoordinate tokyo = new SphericCoordinate(35.70 , 139.767);

        CartesianCoordinate cartesianCoordinate = CoordinateUtil.transformSphericCoordinate(berlin);

        SphericCoordinate sphericCoordinate = CoordinateUtil.transformCartesianCoordinate(cartesianCoordinate);
        System.out.println("Spher: " + sphericCoordinate.getLatitude() + " " + sphericCoordinate.getLongitude());


        SphericCoordinate northPole = new SphericCoordinate(0, 90);
        SphericCoordinate southPole = new SphericCoordinate(0, -90);

        System.out.println(berlin.getDistance(tokyo));

        /**
         * distance between berlin and tokyo
         */
        assertEquals(8918.95, berlin.getDistance(tokyo), 1E-4);
        assertEquals(tokyo.getDistance(berlin), berlin.getDistance(tokyo), 0);

        /**
         * meridian by distance between north and south pole
         */
        assertEquals(SphericCoordinate.EARTH_RADIUS_KM * Math.PI, northPole.getDistance(southPole), 0);

        /**
         * earth radius by distance between north and south pole
         */
        assertEquals(SphericCoordinate.EARTH_RADIUS_KM, southPole.getDistance(northPole) / (Math.PI), 0);
    }


}
