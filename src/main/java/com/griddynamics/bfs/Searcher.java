package com.griddynamics.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Searcher {

    private Set<String> allCities = CityMap.getCities();
    private LinkedList<Path> queue;
    private Set<String> markedCities;

    private void initDataStructures() {
        queue = new LinkedList<Path>();
        markedCities = new HashSet<String>();
    }

    public Path search(String cityFrom, String cityTo) {
        if (!allCities.contains(cityFrom) || !allCities.contains(cityTo))
            return null;
        initDataStructures();
        queue.add(new Path(cityFrom));
        markedCities.add(cityFrom);
        while (!queue.isEmpty()) {
            Path path = queue.getFirst();
            String city = path.getLastCity();
            if (city.equals(cityTo)) {
                return path;
            }
            for (String neighbor : CityMap.getNeighbors(city)) {
                if (!markedCities.contains(neighbor)) {
                    Path newPath = new Path(path.getPath());
                    newPath.addCity(neighbor);
                    queue.addLast(newPath);
                    markedCities.add(neighbor);
                }
            }
            queue.remove(path);
        }
        return null;
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
        Path pathes = searcher.search("Kyiv", "Donetsk");
        System.out.println(pathes);
        pathes = searcher.search("Kremenchug", "Zaporozhye");
        System.out.println(pathes);
    }

}