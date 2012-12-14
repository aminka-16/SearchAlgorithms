package com.griddynamics.bfs;

import java.util.LinkedList;

public class Path {

    private LinkedList<String> pathes;

    public Path(String path) {
        this.pathes = new LinkedList<String>();
        pathes.add(path);
    }

    public Path(LinkedList<String> pathes) {
        this.pathes = pathes;
    }

    public void addCity(String city) {
        pathes.add(city);
    }

    public LinkedList<String> getPath() {
        return new LinkedList<String>(pathes);
    }

    public String getLastCity() {
        return pathes.getLast();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Path: ").append("\r\n");
        for (String s : pathes)
            str.append(s).append("\r\n");
        return str.toString();
    }
}
