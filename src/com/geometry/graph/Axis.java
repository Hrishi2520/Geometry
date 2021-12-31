package com.geometry.graph;

import com.geometry.utils.Range;

final class Axis extends Container {
    final Range range;

    Axis(ContainerLabel label, Range range) {
        super(label);
        this.range = range;
    }

    @Override
    public String toString() {
        return String.format("%s-Axis", label);
    }

    @Override
    boolean inRange(Point point) {
        if (super.label.equals(ContainerLabel.X_AXIS))
            return range.inRange(point.getX()) && point.getY() == 0;
        else if (super.label.equals(ContainerLabel.Y_AXIS))
            return range.inRange(point.getY()) && point.getX() == 0;

        return false;
    }
}