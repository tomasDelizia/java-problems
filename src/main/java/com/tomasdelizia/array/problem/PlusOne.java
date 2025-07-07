package com.tomasdelizia.array.problem;

import java.math.BigInteger;

public class PlusOne {
    public static int[] plusOneWithBigInt(int[] digits) {
        BigInteger num = BigInteger.valueOf(0);
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            int power = n - i - 1;
            BigInteger currentDigit = BigInteger.valueOf(digits[i]);
            num = num.add(currentDigit.multiply(BigInteger.TEN.pow(power)));
        }
        num = num.add(BigInteger.valueOf((1)));
        String numString = num.toString();
        int[] result = new int[numString.length()];
        for (int i = 0; i < numString.length(); i++) {
            int digit = numString.charAt(i) - '0'; // Convert char to int
            result[i] = digit;
        }
        return result;
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
