package com.apollo.leetcode.easy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static com.apollo.leetcode.easy.ConvertBinaryNumberInALinkedListToInteger.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertBinaryNumberInALinkedListToIntegerTest implements ArgumentsProvider {

    private static ConvertBinaryNumberInALinkedListToInteger foo;

    @BeforeAll
    public static void init() {
        foo = new ConvertBinaryNumberInALinkedListToInteger();
    }

    @ParameterizedTest
    @ArgumentsSource(ConvertBinaryNumberInALinkedListToIntegerTest.class)
    public void test(ListNode head, int expectedResult) {
        assertEquals(expectedResult, foo.getDecimalValue(head));
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        ListNode listNodeCase1 =
                new ListNode(1,
                        new ListNode(0,
                                new ListNode(1)));

        ListNode listNodeCase2 = new ListNode(0);

        return Stream.of(
                Arguments.of(listNodeCase1, 5),
                Arguments.of(listNodeCase2, 0)
        );
    }
}
