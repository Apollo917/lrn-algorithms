package com.apollo.leetcode.medium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStockIITest implements ArgumentsProvider {

    private static BestTimeToBuyAndSellStockII foo;

    @BeforeAll
    public static void init() {
        foo = new BestTimeToBuyAndSellStockII();
    }

    @ParameterizedTest
    @ArgumentsSource(BestTimeToBuyAndSellStockIITest.class)
    public void test(int[] input, int expectedResult) {
        assertEquals(expectedResult, foo.start(input));
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 7),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }
}
