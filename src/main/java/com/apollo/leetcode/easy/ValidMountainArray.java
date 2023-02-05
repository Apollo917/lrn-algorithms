package com.apollo.leetcode.easy;

/**
 * 941. Valid Mountain Array
 * <p>
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * Recall that arr is a mountain array if and only if:
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 * @see <a href="https://leetcode.com/problems/valid-mountain-array/">Valid Mountain Array<a/>
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3 || arr[0] >= arr[1] || arr[arr.length - 1] >= arr[arr.length - 2]) {
            return false;
        }

        boolean peakFound = false;

        for (int i = 0; i < arr.length - 1; i++) {
            int current = arr[i];
            int next = arr[i + 1];

            if (current == next) {
                return false;
            }

            if (peakFound && current < next) {
                return false;
            }

            if (!peakFound && current > next) {
                peakFound = true;
            }
        }

        return true;
    }
}
