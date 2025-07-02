package com.tomasdelizia.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphTest {
    @Test
    void testGraph() {
        Graph<String> graph = new Graph<>();
        assertTrue(graph.addVertex("A"));
        assertTrue(graph.addVertex("B"));
        assertTrue(graph.addVertex("C"));
        graph.printGraph();
        assertTrue(graph.addEdge("A", "B"));
        assertTrue(graph.addEdge("A", "C"));
        assertTrue(graph.addEdge("B", "C"));
        graph.printGraph();
        assertTrue(graph.removeEdge("A", "B"));
        assertTrue(graph.removeEdge("A", "C"));
        assertTrue(graph.removeEdge("B", "C"));
        graph.printGraph();
        assertTrue(graph.addEdge("A", "B"));
        assertTrue(graph.addEdge("A", "C"));
        assertTrue(graph.addEdge("B", "C"));
        assertTrue(graph.removeVertex("C"));
        assertFalse(graph.removeVertex("C"));
        graph.printGraph();

    }

}