package com.apollo.leetcode.easy;

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 * <p>
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 * Return the decimal value of the number in the linked list.
 *
 * @see <a href="https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/">Convert Binary Number in a Linked List to Integer<a/>
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        int result = 0;

        ListNode next = head;
        while (next != null) {
            result = (result | next.val) << 1;
            next = next.next;
        }

        return result >> 1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
