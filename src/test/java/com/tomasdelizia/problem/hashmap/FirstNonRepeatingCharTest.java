package com.tomasdelizia.problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FirstNonRepeatingCharTest {
    @Test
    void testFirstNonRepeatingChar() {
        assertNull(FirstNonRepeatingChar.firstNonRepeatingChar(""));
        assertEquals('a', FirstNonRepeatingChar.firstNonRepeatingChar("a"));
        assertNull(FirstNonRepeatingChar.firstNonRepeatingChar("aa"));
        assertEquals('a', FirstNonRepeatingChar.firstNonRepeatingChar("ab"));
        assertEquals('g', FirstNonRepeatingChar.firstNonRepeatingChar("aabbccddeeffg"));
        assertNull(FirstNonRepeatingChar.firstNonRepeatingChar("aabbccddeeffgg"));
    }

}