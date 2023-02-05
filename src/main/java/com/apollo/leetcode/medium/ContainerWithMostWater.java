package com.apollo.leetcode.medium;

/**
 * 11. Container With Most Water
 * <p>
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * @see <a href="https://leetcode.com/problems/container-with-most-water/">Container With Most Water<a/>
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int result = 0;

        for (int s = 0, e = height.length - 1; s < e; ) {
            result = Math.max(result, Math.min(height[s], height[e]) * (e - s));

            if (height[s] > height[e]) {
                e--;
            } else {
                s++;
            }
        }

        return result;
    }
}
