package com.geometry;

import com.geometry.graph.Graph;
import com.geometry.graph.Point;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Graph friends = new Graph("friends");
        friends.print();
        Point ketan = friends.addPoint(5, 0, "ketan");
        friends.print();
        Point hrishi = friends.addPoint(0, 2, "hrishi");
        friends.print();
        Point differentHrishi = friends.addPoint(32, 2, "hrishi");
        friends.print();
        Point duplicate = friends.addPoint(0, 2, "duplicate");
        friends.print();
        Point vishal = friends.addPoint(-234, -654, "vishal");
        friends.print();
        System.out.printf("Distance between %s and %s is %.2f units\n", ketan, hrishi, ketan.distanceFrom(hrishi));
        friends.move(hrishi, 5, 33);
        friends.print();
    }
}
