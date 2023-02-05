package com.apollo.leetcode.medium;

/**
 * 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 * <p>
 * Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k
 * and average greater than or equal to threshold.
 *
 * @see <a href="https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/">Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold<a/>
 */
public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int subArraySum = 0;

        for (int i = 0; i < arr.length; i++) {
            subArraySum += arr[i];

            if (i >= k - 1) {
                if (subArraySum / k >= threshold) result++;
                subArraySum -= arr[i - k + 1];
            }
        }

        return result;
    }

}
