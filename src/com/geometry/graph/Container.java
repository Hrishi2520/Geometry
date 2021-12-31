package com.geometry.graph;

import java.util.LinkedList;
import java.util.List;

abstract class Container {
    final ContainerLabel label;
    List<Point> points;

    Container(ContainerLabel label) {
        this.label = label;
        this.points = new LinkedList<>();
    }

    boolean add(Point candidate) {
        if (find(candidate) || !inRange(candidate)) return false;
        System.out.printf("Adding point %s in %s\n", candidate, label);
        return points.add(candidate);
    }

    boolean find(Point candidate) {
        for (Point point : points) {
            if ((candidate.getX() == point.getX() && candidate.getY() == point.getY()) || point.getLabel().equals(candidate.getLabel()))
                return true;
        }
        return false;
    }

    boolean remove(Point candidate) {
        if (!find(candidate)) return false;
        System.out.printf("Removing point %s from %s\n", candidate, label);
        return points.remove(candidate);
    }

    abstract boolean inRange(Point point);

    void update(Operation operation, Point point) {
        switch (operation) {
            case ADD -> add(point);
            case REMOVE -> remove(point);
        }
    }

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
