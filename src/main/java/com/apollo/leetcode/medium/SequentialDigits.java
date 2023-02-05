package com.apollo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1291. Sequential Digits
 * <p>
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 *
 * @see <a href="https://leetcode.com/problems/sequential-digits/">Sequential Digits<a/>
 */
public class SequentialDigits {

    public List<Integer> sequentialDigitsOne(int low, int high) {
        List<Integer> result = new ArrayList<>();
        final String sequence = "123456789";

        for (int currentWidth = String.valueOf(low).length(); currentWidth <= String.valueOf(high).length(); currentWidth++) {
            for (int offset = 0; offset + currentWidth <= sequence.length(); offset++) {
                int value = Integer.parseInt(sequence.substring(offset, offset + currentWidth));

                if(value >= low) {
                    if(value <= high) {
                        result.add(value);
                    } else {
                        return result;
                    }
                }
            }
        }

        return result;
    }

    public List<Integer> sequentialDigitsTwo(int low, int high) {
        List<Integer> result = new ArrayList<>();
        double sequence = 0.123456789;

        for (int currentWidth = String.valueOf(low).length(); currentWidth <= String.valueOf(high).length(); currentWidth++) {
            for (int offset = 0; offset + currentWidth <= 9; offset++) {
                int widthMultiplier = (int) Math.pow(10, currentWidth + offset);
                int adjustment = (int) (((int) (sequence * Math.pow(10, offset))) * Math.pow(10, currentWidth));
                int unadjustedValue = (int) (sequence * widthMultiplier);
                int value = unadjustedValue - adjustment;

                if(value >= low) {
                    if(value <= high) {
                        result.add(value);
                    } else {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
