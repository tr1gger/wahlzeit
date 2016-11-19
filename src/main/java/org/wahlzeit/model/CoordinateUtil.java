package org.wahlzeit.model;

public class CoordinateUtil {


    public static SphericCoordinate transformCartesianCoordinate(CartesianCoordinate cartesianCoordinate){

        /**
         * transformation of cartesian coordinates into spherical
         * further information http://www.mathepedia.de/Kugelkoordinaten.aspx
         */
        double x = cartesianCoordinate.getX();
        double y = cartesianCoordinate.getY();
        double z = cartesianCoordinate.getZ();

        if(x == 0 && y == 0){
            throw new IllegalArgumentException("x and y must be not 0!");
        }

        double radius = Math.sqrt(x*x + y*y + z*z);
        double delta = SphericCoordinate.EARTH_RADIUS_KM - radius;

        if(Math.abs(delta) > 10E-2) {
            throw new IllegalArgumentException("cartesian coordinates should be on earth! Your Radius is " + radius + " KM");
        }

        double phi;
        double argPhi = x / (Math.sqrt(x*x + y*y));
        double acos = Math.acos(argPhi);

        if(y >= 0){
            phi = acos;
        } else {
            phi = 2 * Math.PI - acos;
        }

        double argTan = z / Math.sqrt(x*x + y*y);
        double lambda = Math.PI / 2 - Math.atan(argTan);


        return new SphericCoordinate(Math.toDegrees(lambda), Math.toDegrees(phi));
    }

    public static CartesianCoordinate transformSphericCoordinate(SphericCoordinate sphericCoordinate){

        /**
         * transform spheric coordinate https://de.wikipedia.org/wiki/Kugelkoordinaten
         */
        double theta = Math.toRadians(sphericCoordinate.getLatitude());
        double phi = Math.toRadians(sphericCoordinate.getLongitude());

        double x = SphericCoordinate.EARTH_RADIUS_KM * Math.sin(theta) * Math.cos(phi);
        double y = SphericCoordinate.EARTH_RADIUS_KM * Math.sin(theta) * Math.sin(phi);
        double z = SphericCoordinate.EARTH_RADIUS_KM * Math.cos(theta);

        return new CartesianCoordinate(x, y, z);
    }

}
