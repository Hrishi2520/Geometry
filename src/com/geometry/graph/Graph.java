package com.geometry.graph;

import com.geometry.utils.Range;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Graph {
    public static final Point origin = new Point(0,0,"origin");
    private static final Container FIRST_QUADRANT = new Quadrant("first", new Range(0, Integer.MAX_VALUE), new Range(0, Integer.MAX_VALUE));
    private static final Container SECOND_QUADRANT = new Quadrant("second", new Range(Integer.MIN_VALUE, 0), new Range(Integer.MAX_VALUE, 0));
    private static final Container THIRD_QUADRANT = new Quadrant("third", new Range(Integer.MIN_VALUE, 0), new Range(Integer.MIN_VALUE, 0));
    private static final Container FOURTH_QUADRANT = new Quadrant("fourth", new Range(0, Integer.MAX_VALUE), new Range(Integer.MIN_VALUE, 0));
    private static final Container X_AXIS = new Axis("X", new Range(Integer.MIN_VALUE, Integer.MAX_VALUE));
    private static final Container Y_AXIS = new Axis("Y", new Range(Integer.MIN_VALUE, Integer.MAX_VALUE));
    private String label;
    private final List<Point> points;

    public Graph(String label) {
        this.label = label;
        points = new LinkedList<>();
        points.add(origin);
    }

    public Point addPoint(double x, double y, String label) {
        if ((x == 0 && y == 0) || label.toLowerCase(Locale.ROOT).equals(origin.getLabel())) {
            System.out.print("Cannot re-create origin! Already added at initialization.\n");
            return null;
        }

        Point newPoint = new Point(x, y, label);
        Container container = findContainer(newPoint);
        if (!container.checkIfExits(newPoint)) {
            container.points.add(newPoint);
            points.add(newPoint);
            System.out.printf("Successfully added %s in %s\n", newPoint, container);
            return newPoint;
        }

        System.out.printf("Adding %s failed\n", newPoint);
        return null;
    }

    public Point addPoint(double x, double y) {
        return addPoint(x, y, String.format("unnamed_%d", getPoints().size()));
    }

    private Container findContainer(Point point) {
        Container found = null;
        if (FIRST_QUADRANT.inRange(point))
            found = FIRST_QUADRANT;
        else if (SECOND_QUADRANT.inRange(point))
            found = SECOND_QUADRANT;
        else if (THIRD_QUADRANT.inRange(point))
            found = THIRD_QUADRANT;
        else if (FOURTH_QUADRANT.inRange(point))
            found = FOURTH_QUADRANT;
        else if (X_AXIS.inRange(point))
            found = X_AXIS;
        else if (Y_AXIS.inRange(point))
            found = Y_AXIS;

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

    public Point movePoint(double x, double y, double newX, double newY) {
        Point found = findPoint(x, y);
        if (found != null) {
            removePoint(found);
            findContainer(found).points.remove(found);
            return addPoint(newX, newY, found.getLabel());
        }

        return null;
    }

    Point pop(Point point) {
        Point found = findPoint(point);
        if (found != null) {
            points.remove(found);
            Container container = findContainer(found);
            container.points.remove(found);
            System.out.printf("Successfully removed %s from %s\n", found, container);

        }
        return found;
    }

    public boolean removePoint(String label) {
        Point found = findPoint(label);
        return pop(found) != null;
    }

    public boolean removePoint(Point point) {
        return pop(point) != null;
    }

    public boolean removePoint(double x, double y) {
        Point found = findPoint(x, y);
        return pop(found) != null;
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
