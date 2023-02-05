package com.apollo.leetcode.easy;

/**
 * 2114. Maximum Number of Words Found in Sentences
 * <p>
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 * You are given an array of strings sentences, where each sentences[i] represents a single sentence.
 * Return the maximum number of words that appear in a single sentence.
 *
 * @see <a href="https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/">Maximum Number of Words Found in Sentences<a/>
 */
public class MaximumNumberOfWordsFoundInSentences {

    public int mostWordsFound(String[] sentences) {
        int result = 0;

        for (String sentence : sentences) {
            int sentenceWordsCount = 1;

            for (char ch : sentence.toCharArray()) {
                if (ch == ' ') sentenceWordsCount++;
            }

            result = Math.max(result, sentenceWordsCount);
        }

        return result;
    }
}
