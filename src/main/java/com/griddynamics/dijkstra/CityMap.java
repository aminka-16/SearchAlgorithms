package com.griddynamics.dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CityMap {

    private static Map<String, Map<String, Integer>> cities = new HashMap<String, Map<String, Integer>>();

    static {

        Map<String, Integer> neighbors = new HashMap<String, Integer>();
        neighbors.put("Poltava", 30);
        neighbors.put("Dnipropetrovsk", 35);
        neighbors.put("Donetsk", 70);
        cities.put("Kharkov", neighbors);

        neighbors = new HashMap<String, Integer>();
        neighbors.put("Kharkov", 70);
        neighbors.put("Zaporozhye", 65);
        cities.put("Donetsk", neighbors);

        neighbors = new HashMap<String, Integer>();
        neighbors.put("Dnipropetrovsk", 15);
        neighbors.put("Donetsk", 65);
        neighbors.put("Krivoi Rog", 30);
        neighbors.put("Nikolaev", 60);
        cities.put("Zaporozhye", neighbors);

        neighbors = new HashMap<String, Integer>();
        neighbors.put("Zaporozhye", 15);
        neighbors.put("Kharkov", 35);
        neighbors.put("Krivoi Rog", 20);
        neighbors.put("Kremenchug", 25);
        cities.put("Dnipropetrovsk", neighbors);

        neighbors = new HashMap<String, Integer>();
        neighbors.put("Kremenchug", 30);
        neighbors.put("Kharkov", 30);
        neighbors.put("Piryatun", 40);
        cities.put("Poltava", neighbors);

        neighbors = new HashMap<String, Integer>();
        neighbors.put("Poltava", 30);
        neighbors.put("Dnipropetrovsk", 25);
        neighbors.put("Krivoi Rog", 15);
        neighbors.put("Cherkassy", 40);
        cities.put("Kremenchug", neighbors);

        neighbors = new HashMap<String, Integer>();
        neighbors.put("Poltava", 40);
        neighbors.put("Kyiv", 30);
        neighbors.put("Cherkassy", 15);
        cities.put("Piryatun", neighbors);

        neighbors = new HashMap<String, Integer>();
        neighbors.put("Piryatun", 30);
        neighbors.put("Cherkassy", 30);
        cities.put("Kyiv", neighbors);

        neighbors = new HashMap<String, Integer>();
        neighbors.put("Piryatun", 15);
        neighbors.put("Kyiv", 30);
        neighbors.put("Kremenchug", 40);
        cities.put("Cherkassy", neighbors);

        neighbors = new HashMap<String, Integer>();
        neighbors.put("Dnipropetrovsk", 20);
        neighbors.put("Zaporozhye", 30);
        neighbors.put("Kremenchug", 15);
        neighbors.put("Nikolaev", 50);
        cities.put("Krivoi Rog", neighbors);

        neighbors = new HashMap<String, Integer>();
        neighbors.put("Krivoi Rog", 50);
        neighbors.put("Zaporozhye", 60);
        cities.put("Nikolaev", neighbors);
    }

    public static Map<String, Integer> getNeighbors(String city) {
        return cities.get(city);
    }

    public static Set<String> getCities() {
        return cities.keySet();
    }
}
