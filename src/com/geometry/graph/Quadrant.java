package com.geometry.graph;

import com.geometry.utils.Range;

import java.util.Locale;

final class Quadrant extends Container {
    final Range rangeX;
    final Range rangeY;

    Quadrant(String label, Range rangeX, Range rangeY) {
        super(label.toUpperCase(Locale.ROOT));
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