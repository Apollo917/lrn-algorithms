package com.apollo.leetcode.easy;

import java.util.function.Function;

/**
 * 2379. Minimum Recolors to Get K Consecutive Black Blocks
 * <p>
 * You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B',
 * representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.
 * <p>
 * You are also given an integer k, which is the desired number of consecutive black blocks.
 * <p>
 * In one operation, you can recolor a white block such that it becomes a black block.
 * <p>
 * Return the minimum number of operations needed such that there is at least one occurrence of k
 * consecutive black blocks.
 *
 * @see <a href="https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/">Minimum Recolors to Get K Consecutive Black Blocks<a/>
 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public int minimumRecolors(String blocks, int k) {
        int minOps = Integer.MAX_VALUE;
        int currentBlockOps = 0;
        Function<Integer, Integer> toOperationCost = (i) -> blocks.charAt(i) == 'W' ? 1 : 0;

        for (int i = 0; i < blocks.length(); i++) {
            currentBlockOps += toOperationCost.apply(i);

            if (i >= k - 1) {
                minOps = Math.min(minOps, currentBlockOps);
                currentBlockOps -= toOperationCost.apply(i - (k - 1));
            }
        }

        return minOps;
    }

}
