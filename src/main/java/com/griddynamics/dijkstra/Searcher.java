package com.griddynamics.dijkstra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Searcher {

    private Set<String> allCities = CityMap.getCities();
    private LinkedList<Path> queue;
    private Set<String> markedCities;

    //TODO: check the algorithm!!!
    public Path search(String cityFrom, String cityTo) {
        if (!allCities.contains(cityFrom) || !allCities.contains(cityTo))
            return null;
        queue = new LinkedList<Path>();
        markedCities = new HashSet<String>();
        Path initialPath = new Path(cityFrom, 0);
        HashMap<String, Path> shortestPathes = new HashMap<String, Path>();
        queue.add(initialPath);
        while (!queue.isEmpty()) {
            Path path = queue.getFirst();
            String city = path.getLastCity();
            Map<String, Integer> neighbors = CityMap.getNeighbors(city);
            for (String neighborName : neighbors.keySet()) {
                if (!markedCities.contains(neighborName)) {
                    if (!shortestPathes.containsKey(neighborName)) {
                        LinkedList<String> newPath = path.getPath();
                        newPath.addLast(neighborName);
                        int newDistance = neighbors.get(neighborName) + path.getDistance();
                        shortestPathes.put(neighborName, new Path(newPath, newDistance));
                        queue.addLast(new Path(newPath, newDistance));
                    } else {
                        Path oldPath = shortestPathes.get(neighborName);
                        int newdistance = path.getDistance() + neighbors.get(neighborName);
                        if (oldPath.getDistance() > newdistance) {
                            LinkedList<String> newPath = path.getPath();
                            shortestPathes.put(neighborName, new Path(newPath, newdistance));
                        }
                    }
                    markedCities.add(city);
                }
            }
            queue.remove(path);
        }
        return shortestPathes.get(cityTo);
    }

    // Zaporozhye
    // Kharkov
    // Poltava
    // Dnipropetrovsk
    // Donetsk
    // Krivoi Rog
    // Kremenchug
    // Nikolaev
    // Cherkassy
    // Piryatun
    // Kyiv

    public static void main(String[] args) {
        Searcher searcher = new Searcher();
        Path pathes = searcher.search("Kremenchug", "Kremenchug");
        System.out.println(pathes);
    }

}
