package com.tomasdelizia.string;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int n = strs.length;
        String ref = strs[0];
        if (n == 1) return ref;
        for (int i = 0; i < ref.length(); i++) {
            char c = ref.charAt(i);
            for (int j = 1; j < n; j++) {
                String current = strs[j];
                if (current.length() <= i || current.charAt(i) != c) {
                    return sb.toString();
                }
                if (j == n - 1) sb.append(c);
            }
        }
        return sb.toString();
    }
}
