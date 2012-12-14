package com.griddynamics.bfs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SearcherTest {
    private Searcher searcher;
    private Path path;

    @Before
    public void initHeap() {
        searcher = new Searcher();
    }

    @Test
    public void testSearchPathToNearCities() {
        path = searcher.search("Kremenchug", "Zaporozhye");
        String[] expected = new String[] { "Kremenchug", "Krivoi Rog", "Zaporozhye" };
        assertEquals(expected, path.getPath().toArray());
    }

    @Test
    public void testSearchPathToNeighbors() {
        path = searcher.search("Poltava", "Kharkov");
        String[] expected = new String[] { "Poltava", "Kharkov" };
        assertEquals(expected, path.getPath().toArray());
    }

    @Test
    public void testSearchPathToTheSameCity() {
        path = searcher.search("Kyiv", "Kyiv");
        String[] expected = new String[] { "Kyiv" };
        assertEquals(expected, path.getPath().toArray());
    }

    @Test
    public void testSearchPathToFarCities() {
        path = searcher.search("Kyiv", "Donetsk");
        String[] expected = new String[] { "Kyiv", "Piryatun", "Poltava", "Kharkov", "Donetsk" };
        assertEquals(expected, path.getPath().toArray());
    }
}
