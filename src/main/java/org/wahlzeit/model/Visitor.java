package org.wahlzeit.model;

interface Visitor {

    double getDistance();
    boolean isEqual();

    void visit(CartesianCoordinate cartesianCoordinate);
    void visit(SphericCoordinate sphericCoordinate);
}
