package com.tomasdelizia.graph;

import java.util.List;

public record FullPathInfo<T>(int distance, List<T> path) {}
