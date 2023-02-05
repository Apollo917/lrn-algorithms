package com.apollo.leetcode.easy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInABinarySearchTreeTest implements ArgumentsProvider {

    private static SearchInABinarySearchTree foo;

    @BeforeAll
    public static void init() {
        foo = new SearchInABinarySearchTree();
    }

    @ParameterizedTest
    @ArgumentsSource(SearchInABinarySearchTreeTest.class)
    public void test(SearchInABinarySearchTree.TreeNode root, int val, SearchInABinarySearchTree.TreeNode expectedResult) {
        assertEquals(expectedResult, foo.searchBST(root, val));
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        /*Example 1*/
        SearchInABinarySearchTree.TreeNode tree1node1 = new SearchInABinarySearchTree.TreeNode(4);
        SearchInABinarySearchTree.TreeNode tree1node2 = new SearchInABinarySearchTree.TreeNode(2);
        SearchInABinarySearchTree.TreeNode tree1node3 = new SearchInABinarySearchTree.TreeNode(7);
        SearchInABinarySearchTree.TreeNode tree1node4 = new SearchInABinarySearchTree.TreeNode(1);
        SearchInABinarySearchTree.TreeNode tree1node5 = new SearchInABinarySearchTree.TreeNode(3);

        tree1node1.setLeft(tree1node2);
        tree1node1.setRight(tree1node3);
        tree1node2.setLeft(tree1node4);
        tree1node2.setRight(tree1node5);

        /*Example 2*/
        SearchInABinarySearchTree.TreeNode tree2node1 = new SearchInABinarySearchTree.TreeNode(4);
        SearchInABinarySearchTree.TreeNode tree2node2 = new SearchInABinarySearchTree.TreeNode(2);
        SearchInABinarySearchTree.TreeNode tree2node3 = new SearchInABinarySearchTree.TreeNode(7);
        SearchInABinarySearchTree.TreeNode tree2node4 = new SearchInABinarySearchTree.TreeNode(1);
        SearchInABinarySearchTree.TreeNode tree2node5 = new SearchInABinarySearchTree.TreeNode(3);

        tree2node1.setLeft(tree2node2);
        tree2node1.setRight(tree2node3);
        tree2node2.setLeft(tree2node4);
        tree2node2.setRight(tree2node5);

        return Stream.of(
                Arguments.of(tree1node1, 2, tree1node2),
                Arguments.of(tree2node1, 5, null)
        );
    }
}
