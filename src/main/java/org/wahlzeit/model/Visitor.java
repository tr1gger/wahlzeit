package org.wahlzeit.model;

interface Visitor {
    double getResult();
    void visit(CartesianCoordinate cartesianCoordinate);
    void visit(SphericCoordinate sphericCoordinate);
}
