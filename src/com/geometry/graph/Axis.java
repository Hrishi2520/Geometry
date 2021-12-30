package com.geometry.graph;

import com.geometry.utils.Range;

import javax.swing.plaf.metal.MetalLookAndFeel;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

final class Axis extends Container {
    final Range range;

    Axis(String label, Range range) {
        super(label.toUpperCase(Locale.ROOT));
        this.range = range;
    }

    @Override
    public String toString() {
        return String.format("%s-Axis", label);
    }

    @Override
    boolean inRange(Point point) {
        if (super.label.equals("X"))
            return range.inRange(point.getX()) && point.getY() == 0;
        else if (super.label.equals("Y"))
            return range.inRange(point.getY()) && point.getX() == 0;

        return false;
    }
}