package org.wahlzeit.model;

abstract class AbstractCoordinate implements Coordinate {
    public abstract void visit(Visitor v);
}

