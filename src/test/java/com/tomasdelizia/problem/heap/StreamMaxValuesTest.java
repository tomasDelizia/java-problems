package com.tomasdelizia.problem.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamMaxValuesTest {
    @Test
    void testStreamMaxValues() {
        assertEquals("[1]", StreamMaxValues.streamMaxValues(new int[]{1}).toString());
        assertEquals("[1, 2]", StreamMaxValues.streamMaxValues(new int[]{1, 2}).toString());
        assertEquals("[3, 3, 3]", StreamMaxValues.streamMaxValues(new int[]{3, 2, 1}).toString());
        assertEquals("[5, 5, 5, 5]", StreamMaxValues.streamMaxValues(new int[]{5, 4, 3, 2}).toString());
        assertEquals("[10, 20, 30]", StreamMaxValues.streamMaxValues(new int[]{10, 20, 30}).toString());
    }

}