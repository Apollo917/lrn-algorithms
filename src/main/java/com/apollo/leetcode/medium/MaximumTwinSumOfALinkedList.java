package com.apollo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 2130. Maximum Twin Sum of a Linked List
 * <p>
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 *
 * @see <a href="https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/">Maximum Twin Sum of a Linked List<a/>
 */
public class MaximumTwinSumOfALinkedList {

    public int pairSum(ListNode head) {
        int result = 0;
        List<Integer> values = new ArrayList<>();

        ListNode next = head;
        while (next != null) {
            values.add(next.val);
            next = next.next;
        }

        for (int i = 0; i < values.size() / 2; i++) {
            result = Math.max(result, values.get(i) + values.get(values.size() - 1 - i));
        }

        return result;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
