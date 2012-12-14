package com.griddynamics.astar;

import java.util.LinkedList;

public class Path {
    private LinkedList<String> path = new LinkedList<String>();

    private int pathCost = 0;
    private int heuristicEstimate = 0;

    public Path(String city) {
        this.path.add(city);
    }

    public Path(LinkedList<String> pathes) {
        this.path = pathes;
    }

    public void addCity(String city) {
        path.addLast(city);
    }

    public LinkedList<String> getPath() {
        return new LinkedList<String>(path);
    }

    public String getLastCity() {
        return path.getLast();
    }

    public int getPathCost() {
        return pathCost;
    }

    public void setPathCost(int newCost) {
        this.pathCost = newCost;
    }

    public int getHevristicEstimate() {
        return this.heuristicEstimate;
    }

    public void setHevristicEstimate(int heuristicEstimate) {
        this.heuristicEstimate = heuristicEstimate;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Path: ").append("\r\n");
        for (String s : path)
            str.append(s).append("\r\n");
        return str.toString();
    }
}
