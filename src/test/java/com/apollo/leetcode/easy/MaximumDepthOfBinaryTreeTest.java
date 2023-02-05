package com.apollo.leetcode.easy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumDepthOfBinaryTreeTest implements ArgumentsProvider {

    private static MaximumDepthOfBinaryTree foo;

    @BeforeAll
    public static void init() {
        foo = new MaximumDepthOfBinaryTree();
    }

    @ParameterizedTest
    @ArgumentsSource(MaximumDepthOfBinaryTreeTest.class)
    public void test(MaximumDepthOfBinaryTree.TreeNode root, int expectedResult) {
        assertEquals(expectedResult, foo.maxDepth(root));
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        /*Example 1*/
        MaximumDepthOfBinaryTree.TreeNode tree1node1 = new MaximumDepthOfBinaryTree.TreeNode(3);
        MaximumDepthOfBinaryTree.TreeNode tree1node2 = new MaximumDepthOfBinaryTree.TreeNode(9);
        MaximumDepthOfBinaryTree.TreeNode tree1node3 = new MaximumDepthOfBinaryTree.TreeNode(20);
        MaximumDepthOfBinaryTree.TreeNode tree1node4 = new MaximumDepthOfBinaryTree.TreeNode(15);
        MaximumDepthOfBinaryTree.TreeNode tree1node5 = new MaximumDepthOfBinaryTree.TreeNode(7);

        tree1node1.setLeft(tree1node2);
        tree1node1.setRight(tree1node3);
        tree1node3.setLeft(tree1node4);
        tree1node3.setRight(tree1node5);

        /*Example 2*/
        MaximumDepthOfBinaryTree.TreeNode tree2node1 = new MaximumDepthOfBinaryTree.TreeNode(1);
        MaximumDepthOfBinaryTree.TreeNode tree2node2 = new MaximumDepthOfBinaryTree.TreeNode(2);

        tree2node1.setRight(tree2node2);

        return Stream.of(
                Arguments.of(tree1node1, 3),
                Arguments.of(tree2node1, 2)
        );
    }
}
