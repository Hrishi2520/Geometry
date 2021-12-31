package com.geometry.graph;

import com.geometry.utils.Range;

import java.util.*;

public class Graph {
    private static final Point origin = new Point(0, 0, "origin");
    private final Map<ContainerLabel, Container> containers;
    private final List<Point> points;
    private String label;

    public Graph(String label) {
        this.label = label;
        points = new LinkedList<>();
        points.add(origin);
        containers = new HashMap<>(){{
            put(ContainerLabel.FIRST_QUADRANT, new Quadrant(ContainerLabel.FIRST_QUADRANT, new Range(0, Integer.MAX_VALUE), new Range(0, Integer.MAX_VALUE)));
            put(ContainerLabel.SECOND_QUADRANT, new Quadrant(ContainerLabel.SECOND_QUADRANT, new Range(Integer.MIN_VALUE, 0), new Range(Integer.MAX_VALUE, 0)));
            put(ContainerLabel.THIRD_QUADRANT, new Quadrant(ContainerLabel.THIRD_QUADRANT, new Range(Integer.MIN_VALUE, 0), new Range(Integer.MIN_VALUE, 0)));
            put(ContainerLabel.FOURTH_QUADRANT, new Quadrant(ContainerLabel.FOURTH_QUADRANT, new Range(0, Integer.MAX_VALUE), new Range(Integer.MIN_VALUE, 0)));
            put(ContainerLabel.X_AXIS, new Axis(ContainerLabel.X_AXIS, new Range(Integer.MIN_VALUE, Integer.MAX_VALUE)));
            put(ContainerLabel.Y_AXIS, new Axis(ContainerLabel.Y_AXIS, new Range(Integer.MIN_VALUE, Integer.MAX_VALUE)));
        }};
    }

    public Point addPoint(double x, double y, String label) {
        if (find(x, y, label) == null) {
            Point point = new Point(x, y, label);
            points.add(point);
            notifyAll(Operation.ADD, point);
            return point;
        }
        System.out.printf("Adding point with x: %.2f, y: %.2f, label: %s failed\n", x, y, label);
        return null;
    }

    public Point addPoint(double x, double y) {
        return addPoint(x, y, String.format("unnamed_%d", getPoints().size()));
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Point> getPoints() {
        return points;
    }

    public Point find(double x, double y, String label) {
        for (Point point : points) {
            if ((point.getX() == x && point.getY() == y)
                    || (point.getLabel().equals(label)))
                return point;
        }
        return null;
    }

    public Point find(double x, double y) {
        return find(x, y, "");
    }

    public Point find(Point point) {
        return find(point.getX(), point.getY(), point.getLabel());
    }

    public boolean remove(Point point) {
        Point found = find(point);
        if (found != null) {
            points.remove(found);
            notifyAll(Operation.REMOVE, found);
        }
        return found != null;
    }

    public boolean move(Point point, double newX, double newY) {
        if (remove(point))
            return addPoint(newX, newY, point.getLabel()) != null;
        return false;
    }

    public void notifyAll(Operation operation, Point point) {
        for (Container container : containers.values())
            container.update(operation, point);
    }

    public void print() {
        System.out.println("******************************************************");
        for (Container container : containers.values())
            System.out.printf("%s: points: %s\n", container.label, container.points);
        System.out.println("******************************************************");
    }
}
