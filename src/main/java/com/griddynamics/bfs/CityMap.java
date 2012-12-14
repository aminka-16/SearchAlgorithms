package com.griddynamics.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CityMap {

    private static Map<String, Set<String>> cities = new HashMap<String, Set<String>>();

    static {

        Set<String> neighbors = new HashSet<String>();
        neighbors.add("Poltava");
        neighbors.add("Dnipropetrovsk");
        neighbors.add("Donetsk");
        cities.put("Kharkov", neighbors);

        neighbors = new HashSet<String>();
        neighbors.add("Kharkov");
        neighbors.add("Zaporozhye");
        cities.put("Donetsk", neighbors);

        neighbors = new HashSet<String>();
        neighbors.add("Dnipropetrovsk");
        neighbors.add("Donetsk");
        neighbors.add("Krivoi Rog");
        neighbors.add("Nikolaev");
        cities.put("Zaporozhye", neighbors);

        neighbors = new HashSet<String>();
        neighbors.add("Zaporozhye");
        neighbors.add("Kharkov");
        neighbors.add("Krivoi Rog");
        neighbors.add("Kremenchug");
        cities.put("Dnipropetrovsk", neighbors);

        neighbors = new HashSet<String>();
        neighbors.add("Kremenchug");
        neighbors.add("Kharkov");
        neighbors.add("Piryatun");
        cities.put("Poltava", neighbors);

        neighbors = new HashSet<String>();
        neighbors.add("Poltava");
        neighbors.add("Dnipropetrovsk");
        neighbors.add("Krivoi Rog");
        neighbors.add("Cherkassy");
        cities.put("Kremenchug", neighbors);

        neighbors = new HashSet<String>();
        neighbors.add("Poltava");
        neighbors.add("Kyiv");
        neighbors.add("Cherkassy");
        cities.put("Piryatun", neighbors);

        neighbors = new HashSet<String>();
        neighbors.add("Piryatun");
        neighbors.add("Cherkassy");
        cities.put("Kyiv", neighbors);

        neighbors = new HashSet<String>();
        neighbors.add("Piryatun");
        neighbors.add("Kyiv");
        neighbors.add("Kremenchug");
        cities.put("Cherkassy", neighbors);

        neighbors = new HashSet<String>();
        neighbors.add("Dnipropetrovsk");
        neighbors.add("Zaporozhye");
        neighbors.add("Kremenchug");
        neighbors.add("Nikolaev");
        cities.put("Krivoi Rog", neighbors);

        neighbors = new HashSet<String>();
        neighbors.add("Krivoi Rog");
        neighbors.add("Zaporozhye");
        cities.put("Nikolaev", neighbors);
    }

    public static Set<String> getNeighbors(String city) {
        return cities.get(city);
    }

    public static Set<String> getCities() {
        return cities.keySet();
    }
}
