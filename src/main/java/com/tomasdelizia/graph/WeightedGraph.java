package com.tomasdelizia.graph;

import java.util.*;

public class WeightedGraph<T> {
    private final Map<T, List<Edge<T>>> adjacencyList = new HashMap<>();

    /**
     * Adds a vertex to the graph.
     * Returns true if the vertex was added successfully, false if it already exists.
     */
    public boolean addVertex(T value) {
        return adjacencyList.putIfAbsent(value, new ArrayList<>()) == null;
    }

    /**
     * Removes a vertex from the graph.
     * Returns true if the vertex was removed successfully, false if it did not exist.
     */
    public boolean addEdge(T value1, T value2, int weight) {
        if (!adjacencyList.containsKey(value1) || !adjacencyList.containsKey(value2)) {
            return false;
        }
        adjacencyList.get(value1).add(new Edge<>(value2, weight));
        adjacencyList.get(value2).add(new Edge<>(value1, weight)); // Assuming undirected graph
        return true;
    }

    /**
     * Calculates the shortest path from the start vertex to all other vertices using Dijkstra's algorithm.
     * @param start the starting vertex
     * @return a map where the keys are vertices and the values are PathInfo objects containing the distance and predecessor
     */
    public Map<T, PathInfo<T>> dijkstraShortestPath(T start) {
        Map<T, PathInfo<T>> shortestPaths = new HashMap<>();
        PriorityQueue<NodeDistance<T>> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));
        Set<T> visited = new HashSet<>();

        for (T vertex : adjacencyList.keySet()) {
            shortestPaths.put(vertex, new PathInfo<>(Integer.MAX_VALUE, null));
        }
        shortestPaths.put(start, new PathInfo<>(0, null));

        pq.add(new NodeDistance<>(start, 0));

        while (!pq.isEmpty()) {
            NodeDistance<T> currentNodeDistance = pq.poll();
            T currentNode = currentNodeDistance.vertex;

            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);

            int currentDistance = shortestPaths.get(currentNode).distance();

            List<Edge<T>> directEdges = adjacencyList.getOrDefault(currentNode, new ArrayList<>());
            for (Edge<T> edge : directEdges) {
                if (visited.contains(edge.target)) continue;

                int newDist = currentDistance + edge.weight;
                if (newDist < shortestPaths.get(edge.target).distance()) {
                    shortestPaths.put(edge.target, new PathInfo<>(newDist, currentNode));
                    pq.add(new NodeDistance<>(edge.target, newDist));
                }
            }
        }

        return shortestPaths;
    }

    /**
     * Reconstructs the shortest path from start to end using the results of Dijkstra's algorithm.
     * @param start the starting vertex
     * @param end the ending vertex
     * @return a list of vertices representing the shortest path from start to end
     */
    public List<T> reconstructPath(T start, T end) {
        Map<T, PathInfo<T>> pathMap = dijkstraShortestPath(start);
        List<T> path = new ArrayList<>();
        for (T at = end; at != null; at = pathMap.get(at).predecessor()) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    /**
     * Reconstructs the shortest path from start to end using the results of Dijkstra's algorithm.
     * @param pathMap a map containing the shortest paths from the start vertex
     * @param end the ending vertex
     * @return a list of vertices representing the shortest path from start to end
     */
    public List<T> reconstructPath(Map<T, PathInfo<T>> pathMap, T end) {
        List<T> path = new ArrayList<>();
        for (T at = end; at != null; at = pathMap.get(at).predecessor()) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    record NodeDistance<T>(T vertex, int distance) {}

    record Edge<T>(T target, int weight) {}
}
