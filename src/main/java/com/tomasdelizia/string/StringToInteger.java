package com.tomasdelizia.string;

public class StringToInteger {
    public static int toInteger(String string) {
        string = string.trim();
        char[] chars = string.toCharArray();
        int n = chars.length;
        if (n == 0) return 0;
        // Determine sign. Assumes positivity if + or neither + nor - is present.
        int sign = chars[0] == '-' ? -1 : 1;
        // If there's a sign character, start iterating from 1.
        int i = chars[0] == '-' || chars[0] == '+' ? 1 : 0;
        // Skip leading zeroes.
        while (i < n && chars[i] == '0') i++;

        long result = 0;
        while (i < n && Character.isDigit(chars[i])) {
            int digit = chars[i] - '0'; // Equivalent to Character.getNumericValue(chars[i]);
            // Check int overflow.
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        result *= sign;
        return (int) result;
    }
}
