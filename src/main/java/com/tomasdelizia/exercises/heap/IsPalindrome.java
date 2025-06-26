package com.tomasdelizia.exercises.heap;

public class IsPalindrome {
    // Time: O(n)
    // Space: O(1)
    public static boolean isPalindromeFromExtremes(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromeFromMiddle(String s) {
        int n = s.length(), half = n / 2, left = half - 1, right = n % 2 == 0 ? half : half + 1;
        while (left >= 0 && right < n) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar != rightChar) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    public static boolean isPalindromeWithForLoop(String s) {
        int n = s.length(), half = n / 2, start = n % 2 == 0 ? half : half + 1;
        String firstHalf = s.substring(0, half);
        for (int i = start; i < n; i++) {
            char charFromRight = s.charAt(i);
            char charFromLeft = firstHalf.charAt(half - 1);
            if (charFromLeft != charFromRight) {
                return false;
            }
            half--;
        }
        return true;
    }
}
