package com.apollo.leetcode.easy;

/**
 * 2269. Find the K-Beauty of a Number
 * <p>
 * The k-beauty of an integer num is defined as the number of substrings of num when it is read as a
 * string that meet the following conditions:
 * <p>
 * It has a length of k.
 * It is a divisor of num.
 * Given integers num and k, return the k-beauty of num.
 * <p>
 * Note:
 * <p>
 * Leading zeros are allowed.
 * 0 is not a divisor of any value.
 * A substring is a contiguous sequence of characters in a string.
 *
 * @see <a href="https://leetcode.com/problems/find-the-k-beauty-of-a-number/">Find the K-Beauty of a Number<a/>
 */
public class FindTheKBeautyOfANumber {

    public int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int result = 0;
        StringBuilder buff = new StringBuilder();

        for (int i = 0; i < numStr.length(); i++) {
            buff.append(numStr.charAt(i));

            if (i >= k - 1) {
                int candidate = Integer.parseInt(buff.toString());
                result += (candidate > 0) && (num % candidate == 0) ? 1 : 0;
                buff.deleteCharAt(0);
            }
        }

        return result;
    }

}
