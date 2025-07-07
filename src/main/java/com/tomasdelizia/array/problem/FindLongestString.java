package com.tomasdelizia.array.problem;

public class FindLongestString {
    public static String findLongestString(String[] strings) {
        String maxLengthString = strings[0];
        for (int i = 1; i < strings.length; i++) {
            String current = strings[i];
            if (current.length() > maxLengthString.length()) maxLengthString = current;
        }
        return maxLengthString;
    }
}
