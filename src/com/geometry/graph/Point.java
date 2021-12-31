package com.geometry.graph;

public class Point {
    private String label;
    private double x;
    private double y;

    Point(double x, double y, String label) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public double distanceFrom(double x, double y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }

    public double distanceFrom(Point point) {
        return distanceFrom(point.getX(), point.getY());
    }

    public String getLabel() {
        return label;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("%s(%.2f, %.2f)", label, x, y);
    }
}
