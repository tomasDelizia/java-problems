package com.tomasdelizia.string;

public class NeedleInHaystack {
    public static int strStr(String haystack, String needle) {
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int n = haystackChars.length, m = needleChars.length;
        if (m == 0) return 0;
        if (m > n) return -1;
        for (int i = 0; i < n - m + 1; i++) {
            for (int j = 0; j < m; j++) {
                if (haystackChars[i + j] != needleChars[j]) break;
                if (j == m - 1) return i;
            }
        }
        return -1;
    }
}
