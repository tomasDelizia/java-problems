package com.tomasdelizia.hash.problem;

import java.util.HashSet;
import java.util.Set;

public class HasUniqueChars {
    public static boolean hasUniqueChars(String string) {
        Set<Character> seen = new HashSet<>();
        for (Character c : string.toCharArray()) {
            if (seen.contains(c)) return false;
            seen.add(c);
        }
        return true;
    }
}
