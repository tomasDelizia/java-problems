package com.tomasdelizia.hash.problem;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static Character firstNonRepeatingChar(String string) {
        Map<Character, Integer> countPerChar = new HashMap<>();
        for (Character c : string.toCharArray()) {
            countPerChar.merge(c, 1, Integer::sum);
            // Equivalent code:
            // if (countPerChar.get(c) == null) countPerChar.put(c, 1);
            // else countPerChar.put(c, countPerChar.get(c) + 1);
        }
        for (Character c : string.toCharArray()) {
            if (countPerChar.getOrDefault(c, -1).equals(1)) {
                return c;
            }
        }
        return null;
    }
}
