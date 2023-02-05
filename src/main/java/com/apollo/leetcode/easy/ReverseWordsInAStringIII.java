package com.apollo.leetcode.easy;

/**
 * 557. Reverse Words in a String III
 * <p>
 * Given a string s, reverse the order of characters in each word within a sentence while still
 * preserving whitespace and initial word order.
 *
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">Reverse Words in a String III<a/>
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int offset = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == ' ') {
                result.append(' ');
                offset = i + 1;
                continue;
            }

            result.insert(offset, arr[i]);
        }

        return result.toString();
    }

}
