package org.wahlzeit.model;


public class CoordinateUtil {


    /**
     * transforms a CartesianCoordinate to a SphericCoordinate
     * @param cartesianCoordinate coordinate on earth consisting of x, y and z
     * @return SphericCoordinate
     */
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

        if(radius == SphericCoordinate.EARTH_RADIUS_KM){

            System.out.println("RADIUS: " + radius);
           // throw new IllegalArgumentException("cartesian coordinates must be on earth!");
        }

        double phi;
        double argPhi = x / (Math.sqrt(x*x + y*y));
        double acos = Math.acos(Math.toRadians(argPhi));

        if(y >= 0){
            phi = acos;
        } else {
            phi = 2 * Math.PI - acos;
        }

        double argTan = z / Math.sqrt(x*x + y*y);
        double lambda = Math.PI / 2 - Math.atan(argTan);


        return new SphericCoordinate(Math.toDegrees(phi), Math.toDegrees(lambda));
    }



    public static double getDistance(SphericCoordinate sphericCoordinateA, SphericCoordinate sphericCoordinateB){

        double phiA = Math.toRadians(sphericCoordinateA.getLatitude());
        double lambdaA = Math.toRadians(sphericCoordinateA.getLongitude());

        double phiB = Math.toRadians(sphericCoordinateB.getLatitude());
        double lambdaB = Math.toRadians(sphericCoordinateB.getLongitude());

        /**
         * Formula for calculating distance between two points on a round sphere
         * https://de.wikipedia.org/wiki/Orthodrome
         */

        double val = Math.sin(phiA) * Math.sin(phiB)
                + Math.cos(phiA) * Math.cos(phiB) *
                Math.cos(lambdaA - lambdaB);

        return SphericCoordinate.EARTH_RADIUS_KM * Math.acos(val);
    }




}
