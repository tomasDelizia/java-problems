package com.tomasdelizia.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NAryTreeTest {
    @Test
    void dfsWithMultipleLevels() {
        NAryTree<Integer> tree = new NAryTree<>(5);
        tree.addChildrenToNode(5, List.of(3, 4, 6));
        tree.addChildrenToNode(3, List.of(2));
        assertEquals(List.of(5, 3, 2, 4, 6), tree.dfs());
    }

    @Test
    void bfsWithMultipleLevels() {
        NAryTree<Integer> tree = new NAryTree<>(5);
        tree.addChildrenToNode(5, List.of(3, 4, 6));
        tree.addChildrenToNode(3, List.of(2));
        assertEquals(List.of(5, 3, 4, 6, 2), tree.bfs());
    }
}