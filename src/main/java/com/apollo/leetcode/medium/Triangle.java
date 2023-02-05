package com.apollo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. Triangle
 * <p>
 * Given a triangle array, return the minimum path sum from top to bottom.
 * For each step, you may move to an adjacent number of the row below. More formally,
 * if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 *
 * @see <a href="https://leetcode.com/problems/triangle/">Triangle<a/>
 */
//TODO: Dig deeper
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        if (triangle.size() == 1) return triangle.get(0).get(0);

        List<Integer> results = new ArrayList<>(triangle.get(triangle.size() - 1));

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                results.set(j, Math.min(results.get(j), results.get(j + 1)) + triangle.get(i).get(j));
            }
        }

        return results.get(0);
    }
}
