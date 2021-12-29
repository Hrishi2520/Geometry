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


}