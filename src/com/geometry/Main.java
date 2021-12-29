package com.geometry;

import com.geometry.graph.Graph;
import com.geometry.graph.Point;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Graph salary = new Graph("Salary");
        salary.addPoint(10, -15, "ketan");
        salary.addPoint(10, -15, "ketan");
        salary.addPoint(6, 25);
        Point point = salary.addPoint(-4, -12);
        Point bhavesh = salary.addPoint(-70, 100, "Bhavesh");
        System.out.printf("findPoint(%s): %s\n", bhavesh, salary.findPoint(bhavesh));
        System.out.printf("findPoint(%.2f, %.2f): %s\n", -110D, 120D, salary.findPoint(-110D, 120D));
        System.out.printf("findPoint(%s): %s\n", "ketan", salary.findPoint("ketan"));
        System.out.printf("%s points: %s\n", salary.getLabel(), salary.getPoints());

    }
}
