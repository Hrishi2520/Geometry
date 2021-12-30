package com.geometry.graph;

import java.util.LinkedList;
import java.util.List;

abstract class Container {
    final String label;
    List<Point> points;

    Container(String label) {
        this.label = label;
        this.points = new LinkedList<>();
    }

    abstract boolean inRange(Point point);

    boolean checkIfExits(Point point) {
        for (Point p : points) {
            if (p.getLabel().equals(point.getLabel())) {
                System.out.printf("Found %s with same label as %s\n", point, p);
                return true;
            }

            if (p.getX() == point.getX() && p.getY() == point.getY()) {
                System.out.printf("Found %s with same co-ordinates as %s\n", point, p);
                return true;
            }
        }
        return false;
    }
}
