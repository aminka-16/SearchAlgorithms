package com.griddynamics.astar;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CityMap {

    private static Map<String, Map<String, NeighborMetrics>> cities = new HashMap<String, Map<String, NeighborMetrics>>();

    public static class NeighborMetrics {
        private int pathCost;
        private int heuristicEstimate;

        public NeighborMetrics(int pathcost, int heuristicEstimate) {
            this.pathCost = pathcost;
            this.heuristicEstimate = heuristicEstimate;
        }

        public int getPathCost() {
            return this.pathCost;
        }

        public int getHeuristicEstimate() {
            return this.heuristicEstimate;
        }
    }

    static {

        Map<String, NeighborMetrics> neighbors = new HashMap<String, NeighborMetrics>();
        neighbors.put("Poltava", new NeighborMetrics(30, 5));
        neighbors.put("Dnipropetrovsk", new NeighborMetrics(35, 15));
        neighbors.put("Donetsk", new NeighborMetrics(70, 5));
        cities.put("Kharkov", neighbors);

        neighbors = new HashMap<String, NeighborMetrics>();
        neighbors.put("Kharkov", new NeighborMetrics(70, 5));
        neighbors.put("Zaporozhye", new NeighborMetrics(65, 5));
        cities.put("Donetsk", neighbors);

        neighbors = new HashMap<String, NeighborMetrics>();
        neighbors.put("Dnipropetrovsk", new NeighborMetrics(15, 5));
        neighbors.put("Donetsk", new NeighborMetrics(65, 5));
        neighbors.put("Krivoi Rog", new NeighborMetrics(30, 5));
        neighbors.put("Nikolaev", new NeighborMetrics(60, 5));
        cities.put("Zaporozhye", neighbors);

        neighbors = new HashMap<String, NeighborMetrics>();
        neighbors.put("Zaporozhye", new NeighborMetrics(15, 5));
        neighbors.put("Kharkov", new NeighborMetrics(35, 5));
        neighbors.put("Krivoi Rog", new NeighborMetrics(20, 15));
        neighbors.put("Kremenchug", new NeighborMetrics(25, 5));
        cities.put("Dnipropetrovsk", neighbors);

        neighbors = new HashMap<String, NeighborMetrics>();
        neighbors.put("Kremenchug", new NeighborMetrics(30, 5));
        neighbors.put("Kharkov", new NeighborMetrics(30, 5));
        neighbors.put("Piryatun", new NeighborMetrics(40, 5));
        cities.put("Poltava", neighbors);

        neighbors = new HashMap<String, NeighborMetrics>();
        neighbors.put("Poltava", new NeighborMetrics(30, 5));
        neighbors.put("Dnipropetrovsk", new NeighborMetrics(25, 5));
        neighbors.put("Krivoi Rog", new NeighborMetrics(15, 5));
        neighbors.put("Cherkassy", new NeighborMetrics(40, 5));
        cities.put("Kremenchug", neighbors);

        neighbors = new HashMap<String, NeighborMetrics>();
        neighbors.put("Poltava", new NeighborMetrics(40, 5));
        neighbors.put("Kyiv", new NeighborMetrics(30, 5));
        neighbors.put("Cherkassy", new NeighborMetrics(15, 5));
        cities.put("Piryatun", neighbors);

        neighbors = new HashMap<String, NeighborMetrics>();
        neighbors.put("Piryatun", new NeighborMetrics(30, 5));
        neighbors.put("Cherkassy", new NeighborMetrics(30, 5));
        cities.put("Kyiv", neighbors);

        neighbors = new HashMap<String, NeighborMetrics>();
        neighbors.put("Piryatun", new NeighborMetrics(15, 5));
        neighbors.put("Kyiv", new NeighborMetrics(30, 5));
        neighbors.put("Kremenchug", new NeighborMetrics(40, 5));
        cities.put("Cherkassy", neighbors);

        neighbors = new HashMap<String, NeighborMetrics>();
        neighbors.put("Dnipropetrovsk", new NeighborMetrics(20, 5));
        neighbors.put("Zaporozhye", new NeighborMetrics(30, 5));
        neighbors.put("Kremenchug", new NeighborMetrics(15, 5));
        neighbors.put("Nikolaev", new NeighborMetrics(50, 15));
        cities.put("Krivoi Rog", neighbors);

        neighbors = new HashMap<String, NeighborMetrics>();
        neighbors.put("Krivoi Rog", new NeighborMetrics(50, 5));
        neighbors.put("Zaporozhye", new NeighborMetrics(60, 5));
        cities.put("Nikolaev", neighbors);
    }

    public static Map<String, NeighborMetrics> getNeighbors(String city) {
        return cities.get(city);
    }

    public static Set<String> getCities() {
        return cities.keySet();
    }
}
