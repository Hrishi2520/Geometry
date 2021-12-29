package com.geometry.graph;

import com.geometry.utils.Range;

import java.util.LinkedList;
import java.util.List;

final class Quadrant {
    final String label;
    List<Point> points;
    final Range rangeX;
    final Range rangeY;

    Quadrant(String label, Range rangeX, Range rangeY) {
        this.label = label;
        this.rangeX = rangeX;
        this.rangeY = rangeY;
        this.points = new LinkedList<>();
    }

    public boolean checkIfUnique(Point point) {
        for(Point p: points) {
            if (p.getLabel().equals(point.getLabel())) {
                System.out.printf("Found %s with same label as %s\n", point, p);
                return false;
            }

            if (p.getX() == point.getX() && p.getY() == point.getY()) {
                System.out.printf("Found %s with same co-ordinates as %s\n", point, p);
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s", label);
    }
}