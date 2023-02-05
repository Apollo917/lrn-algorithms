package com.apollo.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2367. Number of Arithmetic Triplets
 * <p>
 * You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff.
 * A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:
 * <p>
 * i < j < k
 * <p>
 * nums[j] - nums[i] == diff, and
 * <p>
 * nums[k] - nums[j] == diff.
 * <p>
 * Return the number of unique arithmetic triplets.
 *
 * @see <a href="https://leetcode.com/problems/number-of-arithmetic-triplets/">Number of Arithmetic Triplets<a/>
 */
public class NumberOfArithmeticTriplets {

    public int arithmeticTriplets(int[] nums, int diff) {
        int result = 0;
        int p1 = 0;
        int p2 = 1;
        Set<Integer> buff = new HashSet<>();

        while (p2 < nums.length) {
            int currentDiff = nums[p2] - nums[p1];

            if (currentDiff > diff) {
                p1++;
            } else if (currentDiff < diff) {
                p2++;
            } else {
                buff.add(nums[p2]);
                if (buff.contains(nums[p1])) result++;
                p1++;
                p2++;
            }
        }

        return result;
    }

}
