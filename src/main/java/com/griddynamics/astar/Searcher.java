package com.griddynamics.astar;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.griddynamics.astar.CityMap.NeighborMetrics;

public class Searcher {

    private Set<String> allCities = CityMap.getCities();
    private Set<String> markedCities;
    private PriorityQueue<Path> queue;

    private void initDataStructures() {
        queue = new PriorityQueue<Path>(allCities.size(), new Comparator<Path>() {
            @Override
            public int compare(Path p1, Path p2) {
                return (p1.getPathCost() + p1.getHevristicEstimate()) - (p2.getPathCost() + p2.getHevristicEstimate());
            }
        });
        markedCities = new HashSet<String>();
    }

    public Path search(String cityFrom, String cityTo) {
        if (!allCities.contains(cityFrom) || !allCities.contains(cityTo))
            return null;
        initDataStructures();
        queue.add(new Path(cityFrom));
        while (!queue.isEmpty()) {
            Path path = queue.poll();
            String city = path.getLastCity();
            if (city.equals(cityTo)) {
                return path;
            }
            if (!markedCities.contains(city)) {
                Map<String, NeighborMetrics> neighbors = CityMap.getNeighbors(city);
                for (String neighborName : neighbors.keySet()) {
                    LinkedList<String> pathes = path.getPath();
                    pathes.addLast(neighborName);
                    NeighborMetrics mertics = neighbors.get(neighborName);
                    int newDist = mertics.getPathCost() + path.getPathCost();
                    Path newPath = new Path(pathes);
                    newPath.setHevristicEstimate(mertics.getHeuristicEstimate());
                    newPath.setPathCost(newDist);
                    queue.add(newPath);
                }
                markedCities.add(city);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Searcher searcher = new Searcher();
        Path pathes = searcher.search("Kyiv", "Nikolaev");
        System.out.println(pathes);
    }
}
