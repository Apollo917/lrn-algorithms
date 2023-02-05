package com.apollo.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 2089. Find Target Indices After Sorting Array
 * <p>
 * You are given a 0-indexed integer array nums and a target element target.
 * A target index is an index i such that nums[i] == target.
 * Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
 *
 * @see <a href="https://leetcode.com/problems/find-target-indices-after-sorting-array/">Find Target Indices After Sorting Array<a/>
 */
public class FindTargetIndicesAfterSortingArray {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int targetIndex = Arrays.binarySearch(nums, target);

        if (targetIndex < 0) {
            return new ArrayList<>();
        }

        int leftBoundIndex = targetIndex;
        int rightBoundIndex = targetIndex;

        while (true) {
            leftBoundIndex--;

            if (leftBoundIndex < 0) {
                leftBoundIndex++;
                break;
            }

            if (nums[leftBoundIndex] != target) {
                leftBoundIndex = leftBoundIndex + 1;
                break;
            }
        }

        while (true) {
            rightBoundIndex++;

            if (rightBoundIndex >= nums.length) {
                rightBoundIndex--;
                break;
            }

            if (nums[rightBoundIndex] != target) {
                rightBoundIndex = rightBoundIndex - 1;
                break;
            }
        }

        return IntStream.range(leftBoundIndex, rightBoundIndex + 1).boxed().collect(Collectors.toList());
    }
}
