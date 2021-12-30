package com.geometry.utils;

public final class Range {
    private final double start;
    private final double end;

    public Range(double start, double end) {
        this.start = start;
        this.end = end;
    }

    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }

    public boolean inRange(double element) {
        return (start < element && end > element);
    }
}
