package com.geometry.graph;

import com.geometry.utils.Range;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private static final Quadrant FIRST = new Quadrant("first", new Range(0, Integer.MAX_VALUE), new Range(0, Integer.MAX_VALUE));
    private static final Quadrant SECOND = new Quadrant("second", new Range(Integer.MIN_VALUE, 0), new Range(Integer.MAX_VALUE, 0));
    private static final Quadrant THIRD = new Quadrant("third", new Range(Integer.MIN_VALUE, 0), new Range(Integer.MIN_VALUE, 0));
    private static final Quadrant FOURTH = new Quadrant("fourth", new Range(0, Integer.MAX_VALUE), new Range(Integer.MIN_VALUE, 0));
    private String label;
    private final List<Point> points;

    public Graph(String label) {
        this.label = label;
        points = new LinkedList<>();
    }

    public Point addPoint(double x, double y, String label) {
        Point newPoint = new Point(x, y, label);
        Quadrant container = findQuadrant(newPoint);
        if (container.checkIfUnique(newPoint)) {
            container.points.add(newPoint);
            points.add(newPoint);
            System.out.printf("Successfully created %s in %s-Quadrant\n", newPoint, container);
            return newPoint;
        }

        System.out.printf("Adding %s failed\n", newPoint);
        return null;
    }

    public Point addPoint(double x, double y) {
        return addPoint(x, y, String.format("unnamed_%d", getPoints().size()));
    }

    private Quadrant findQuadrant(Point newPoint) {
        Quadrant found;
        if (FIRST.rangeX.inRange(newPoint.getX()) && FIRST.rangeY.inRange(newPoint.getY())) found = FIRST;
        else if (SECOND.rangeX.inRange(newPoint.getX()) && SECOND.rangeY.inRange(newPoint.getY())) found = SECOND;
        else if (THIRD.rangeX.inRange(newPoint.getX()) && THIRD.rangeY.inRange(newPoint.getY())) found = THIRD;
        else found = FOURTH;
        return found;
    }

    public Point findPoint(double x, double y) {
        for (Point p : points) {
            if (p.getX() == x && p.getY() == y)
                return p;
        }

        return null;
    }

    public Point findPoint(String label) {
        for (Point p : points) {
            if (p.getLabel().equals(label))
                return p;
        }

        return null;
    }

    public Point findPoint(Point point) {
        return points.contains(point) ? point : null;
    }

    public Point pop(String label) {
        points.remove(findPoint(label));
        return null;
    }

    public Point pop(double x, double y) {
        points.remove(findPoint(x,y));
        return null;
    }

    public Point pop(Point point) {
        points.remove(findPoint(point));
        return null;
    }

    public boolean removePoint(String label) {
        return pop(label) != null;
    }

    public boolean removePoint(Point point) {
        return pop(point) != null;
    }

    public boolean removePoint(double x, double y) {
        return pop(x, y) != null;
    }

    public double distanceBetween(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
    }

    public double distanceBetween(Point p1, Point p2) {
        return distanceBetween(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public double distanceBetween(Point point) {
        return distanceBetween(point.getX(), point.getY(), 0, 0);
    }

    public double distanceBetween(String label) {
        Point found = findPoint(label);
        if (found != null)
            return distanceBetween(found.getX(), found.getY(), 0, 0);
        return -1D;
    }

    public double distanceBetween(String labelOne, String labelTwo) {
        Point foundOne = findPoint(labelOne);
        Point foundTwo = findPoint(labelTwo);
        if (foundOne != null && foundTwo != null)
            return distanceBetween(foundOne.getX(), foundOne.getY(), foundTwo.getX(), foundTwo.getY());
        return -1D;
    }

    public double distanceBetween(double x, double y) {
        return distanceBetween(x, y, 0, 0);
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
}
