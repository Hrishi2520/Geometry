package com.geometry;

import com.geometry.graph.Graph;
import com.geometry.graph.Point;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Graph friends = new Graph("friends");
        Point ketan = friends.addPoint(5, 0, "ketan");
        Point hrishi = friends.addPoint(0, 2, "hrishi");
        System.out.printf("Distance between %s and %s is %.2f units\n", ketan, hrishi, friends.distanceBetween(ketan, hrishi));
        friends.movePoint(hrishi.getX(), hrishi.getY(), 5, 33);
    }
}
