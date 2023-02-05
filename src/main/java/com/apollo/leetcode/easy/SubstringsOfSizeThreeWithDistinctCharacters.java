package com.apollo.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1876. Substrings of Size Three with Distinct Characters
 * <p>
 * A string is good if there are no repeated characters.
 * Given a string s, return the number of good substrings of length three in s.
 * Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
 * A substring is a contiguous sequence of characters in a string.
 *
 * @see <a href="https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/">Substrings of Size Three with Distinct Characters<a/>
 */
public class SubstringsOfSizeThreeWithDistinctCharacters {

    private static final int WINDOW_SIZE = 3;


    public int countGoodSubstrings(String s) {
        int goodStringsCount = 0;
        Map<Character, Integer> charsBuffer = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            charsBuffer.compute(s.charAt(i), (ch, count) -> {
                if (count == null) return 1;
                else return count + 1;
            });

            if (i >= WINDOW_SIZE - 1) {
                if (charsBuffer.size() == WINDOW_SIZE) goodStringsCount++;
                charsBuffer.compute(s.charAt(i - (WINDOW_SIZE - 1)), (ch, count) -> --count == 0 ? null : count);
            }
        }

        return goodStringsCount;
    }

}
