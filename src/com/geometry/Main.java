package com.geometry;

import com.geometry.graph.Graph;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Graph newGraph = new Graph("Salary");
        newGraph.addPoint(10, -15, "ketan");
        newGraph.addPoint(10, -15, "ketan");
        newGraph.addPoint(6, 25);
        newGraph.addPoint(-4, -12);
        newGraph.addPoint(-70, 100, "Bhavesh");
        System.out.printf("%s points: %s\n", newGraph.getLabel(), newGraph.points());
    }
}
