package com.geometry.graph;

import com.geometry.utils.Range;

final class Quadrant extends Container {
    final Range rangeX;
    final Range rangeY;

    Quadrant(ContainerLabel label, Range rangeX, Range rangeY) {
        super(label);
        this.rangeX = rangeX;
        this.rangeY = rangeY;
    }

    @Override
    public String toString() {
        return String.format("%s-Quadrant", label);
    }

    @Override
    boolean inRange(Point point) {
        return rangeX.inRange(point.getX()) && rangeY.inRange(point.getY());
    }
}