package com.geometry;

import com.geometry.graph.Graph;
import com.geometry.graph.Point;

public class Main {

    public static void main(String[] args) {
        Graph friends = new Graph("friends");
        friends.print();
        Point ketan = friends.add(5, 0, "ketan");
        friends.print();
        Point hrishi = friends.add(0, 2, "hrishi");
        friends.print();
        Point differentHrishi = friends.add(32, 2, "hrishi");
        friends.print();
        Point duplicate = friends.add(0, 2, "duplicate");
        friends.print();
        Point vishal = friends.add(-234, -654, "vishal");
        friends.print();
        System.out.printf("Distance between %s and %s is %.2f units\n", ketan, hrishi, ketan.distanceFrom(hrishi));
        friends.move(hrishi, 5, 33);
        friends.print();
    }
}
