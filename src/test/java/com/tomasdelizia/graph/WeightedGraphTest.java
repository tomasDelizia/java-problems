package com.tomasdelizia.graph;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WeightedGraphTest {
    @Test
    void testDijsktra() {
        WeightedGraph<String> graph = new WeightedGraph<>();
        assertTrue(graph.addVertex("A"));
        assertTrue(graph.addVertex("B"));
        assertTrue(graph.addVertex("C"));
        assertTrue(graph.addEdge("A", "B", 4));
        assertTrue(graph.addEdge("A", "C", 2));
        assertTrue(graph.addEdge("B", "C", 1));

        Map<String, PathInfo<String>> distances = graph.dijkstraShortestPath("A");
        assertEquals(0, distances.get("A").distance());
        assertNull(distances.get("A").predecessor());
        assertEquals(3, distances.get("B").distance());
        assertEquals("C", distances.get("B").predecessor());
        assertEquals(2, distances.get("C").distance());
        assertEquals("A", distances.get("C").predecessor());
        FullPathInfo<String> expectedPath = new FullPathInfo<>(3, List.of("A", "C", "B"));
        assertEquals(expectedPath, graph.reconstructPath("A", "B"));
        assertEquals(expectedPath, graph.reconstructPath(distances, "B"));
    }

}