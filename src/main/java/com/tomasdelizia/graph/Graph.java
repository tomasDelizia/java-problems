package com.tomasdelizia.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private final Map<T, List<T>> adjacencyList = new HashMap<>();

    public void printGraph() {
        for (T key : adjacencyList.keySet()) {
            System.out.print(key + " -> ");
            List<T> neighbors = adjacencyList.get(key);
            if (neighbors != null) {
                for (T neighbor : neighbors) {
                    System.out.print(neighbor + " ");
                }
            } else {
                System.out.print("null");
            }
            System.out.println();
        }
    }

    /**
     * Adds a vertex to the graph.
     * Returns true if the vertex was added successfully, false if it already exists.
     */
    public boolean addVertex(T value) {
        return adjacencyList.putIfAbsent(value, new ArrayList<>()) == null;
    }

    /**
     * Adds a bidirectional edge between two vertices.
     * Returns true if the edge was added successfully, false if either vertex does not exist.
     */
    public boolean addEdge(T value1, T value2) {
        if (adjacencyList.get(value1) == null || adjacencyList.get(value2) == null) {
            return false;
        }
        adjacencyList.get(value1).add(value2);
        adjacencyList.get(value2).add(value1);
        return true;
    }

    /**
     * Removes a bidirectional edge between two vertices.
     * Returns true if the edge was removed successfully, false if either vertex does not exist or the edge does not exist.
     */
    public boolean removeEdge(T value1, T value2) {
        if (adjacencyList.get(value1) == null || adjacencyList.get(value2) == null) {
            return false;
        }
        adjacencyList.get(value1).remove(value2);
        adjacencyList.get(value2).remove(value1);
        return true;
    }

    /**
     * Removes a vertex and all its associated edges from the graph.
     * Assumes that the vertex has bidirectional edges.
     * Returns true if the vertex was removed successfully, false if it does not exist.
     */
    public boolean removeVertex(T value) {
        if (adjacencyList.get(value) == null) {
            return false;
        }
        // Loop each edge of the vertex to remove
        for (T otherVertex : adjacencyList.get(value)) {
            // Remove the edges in O(1)
            adjacencyList.get(otherVertex).remove(value);
        }
        // Remove the vertex from the hash table
        adjacencyList.remove(value);
        return true;
    }
}
