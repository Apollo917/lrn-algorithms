package com.apollo.leetcode.medium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static com.apollo.leetcode.medium.MaximumTwinSumOfALinkedList.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumTwinSumOfALinkedListTest implements ArgumentsProvider {

    private static MaximumTwinSumOfALinkedList foo;

    @BeforeAll
    public static void init() {
        foo = new MaximumTwinSumOfALinkedList();
    }

    @ParameterizedTest
    @ArgumentsSource(MaximumTwinSumOfALinkedListTest.class)
    public void test(ListNode head, int expectedResult) {
        assertEquals(expectedResult, foo.pairSum(head));
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        ListNode listNodeCase1 =
                new ListNode(5,
                        new ListNode(4,
                                new ListNode(2,
                                        new ListNode(1))));

        ListNode listNodeCase2 =
                new ListNode(4,
                        new ListNode(2,
                                new ListNode(2,
                                        new ListNode(3))));

        ListNode listNodeCase3 =
                new ListNode(1,
                        new ListNode(100000));


        return Stream.of(
                Arguments.of(listNodeCase1, 6),
                Arguments.of(listNodeCase2, 7),
                Arguments.of(listNodeCase3, 100001)
        );
    }
}
