package com.tomasdelizia.string;

public class ReverseInteger {
    public static int reverseUsingString(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int n = chars.length;
        boolean negative = chars[0] == '-';
        int left = negative ? 1 : 0, right = n - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        try {
            return Integer.parseInt(String.valueOf(chars));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int reverseUsingMath(int x) {
        long rev = 0;
        int temp = x;
        while (temp != 0) {
            int digit = temp % 10;
            rev = 10 * rev + digit;
            if (rev > Integer.MAX_VALUE) return 0;
            if (rev < Integer.MIN_VALUE) return 0;
            temp /= 10;
        }
        return (int) rev;
    }
}
