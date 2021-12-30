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
        Point flash = salary.addPoint(-70, 100, "Flash");
        System.out.printf("findPoint(%s): %s\n", bhavesh, salary.findPoint(bhavesh));
        System.out.printf("findPoint(%.2f, %.2f): %s\n", -110D, 120D, salary.findPoint(-110D, 120D));
        System.out.printf("findPoint(%s): %s\n", "ketan", salary.findPoint("ketan"));
        System.out.printf("%s points: %s\n", salary.getLabel(), salary.getPoints());
        System.out.printf("pop(%s): %b\n", "ketan", salary.pop("ketan"));
        System.out.printf("findPoint(%s): %s\n", "ketan", salary.findPoint("ketan"));
        System.out.printf("pop(%.2f, %.2f): %b\n", -110D, 120D, salary.pop(-110D, 120D));
        System.out.printf("findPoint(%.2f, %.2f): %s\n", -110D, 120D, salary.findPoint(-110D, 120D));
        System.out.printf("pop(%s): %b\n", bhavesh, salary.pop(bhavesh));
        System.out.printf("findPoint(%s): %s\n", bhavesh, salary.findPoint(bhavesh));
        System.out.printf("Distance between (%.2f, %.2f) and (%.2f, %.2f): %s\n",19D, 22D, 45D, 11D, salary.distanceBetween(19,22,45,11));
        System.out.printf("pop(%s): %b\n", "shedge", salary.pop("shedge"));
        System.out.printf("pop(%.2f, %.2f): %b\n", 25D, 20D, salary.pop(25,20));
        System.out.printf("distance between two points %s and %s is: %.2f \n", "labelOne", "labelTwo", salary.distanceBetween("labelOne", "labelTwo"));
        System.out.printf("distance between two points %s and origin: %.2f\n", "shedge", salary.distanceBetween("shedge"));

    }
}
