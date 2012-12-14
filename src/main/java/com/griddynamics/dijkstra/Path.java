package com.griddynamics.dijkstra;

import java.util.LinkedList;

public class Path {

    private LinkedList<String> pathes;
    private int distance;

    public Path(String path, int distance) {
        this.pathes = new LinkedList<String>();
        pathes.add(path);
        this.distance = distance;
    }

    public Path(LinkedList<String> pathes, int distance) {
        this.pathes = pathes;
        this.distance = distance;
    }

    public String getLastCity() {
        return pathes.getLast();
    }

    public LinkedList<String> getPath() {
        return new LinkedList<String>(pathes);
    }

    public int getDistance() {
        return distance;
    }

    public void addCity(String city) {
        pathes.addLast(city);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Distance: ").append(distance).append("\r\n").append("Path: ").append("\r\n");
        for (String s : pathes)
            str.append(s).append("\r\n");
        return str.toString();
    }
}
