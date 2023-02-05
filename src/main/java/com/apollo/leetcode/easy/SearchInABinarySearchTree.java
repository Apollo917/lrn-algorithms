package com.apollo.leetcode.easy;

import java.util.Objects;

/**
 * 700. Search in a Binary Search Tree
 * <p>
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 *
 * @see <a href="https://leetcode.com/problems/search-in-a-binary-search-tree/">Search in a Binary Search Tree<a/>
 */
//TODO: Dig deeper
public class SearchInABinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
    }

    //Haven't noticed that tree left node always < val and right node > val
    /*TreeNode result = null;

    if (root == null) {
        return null;
    } else if (root.val == val) {
        return root;
    }

    if (root.left != null) {
        result = searchBST(root.left, val);
    }

    if (result == null && root.right != null) {
        result = searchBST(root.right, val);
    }

    return result;*/

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}
