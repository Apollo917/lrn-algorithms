package com.apollo.leetcode.medium;

/**
 * 1358. Number of Substrings Containing All Three Characters
 * <p>
 * Given a string s consisting only of characters a, b and c.
 * <p>
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 *
 * @see <a href="https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/">Number of Substrings Containing All Three Characters<a/>
 */
public class NumberOfSubstringsContainingAllThreeCharacters {

    public int numberOfSubstrings(String s) {
        int[] pointers = new int[]{-1, -1, -1};
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            pointers[s.charAt(i) - 'a'] = i;

            if (pointers[0] != -1 && pointers[1] != -1 && pointers[2] != -1) {
                result += 1 + Math.min(pointers[0], Math.min(pointers[1], pointers[2]));
            }
        }

        return result;
    }

}
