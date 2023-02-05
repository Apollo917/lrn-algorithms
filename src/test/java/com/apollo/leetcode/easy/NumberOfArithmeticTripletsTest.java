package com.apollo.leetcode.easy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfArithmeticTripletsTest implements ArgumentsProvider {

    private static NumberOfArithmeticTriplets foo;

    @BeforeAll
    public static void init() {
        foo = new NumberOfArithmeticTriplets();
    }


    @ParameterizedTest
    @ArgumentsSource(NumberOfArithmeticTripletsTest.class)
    public void test(int[] nums, int diff, int expectedResult) {
        assertEquals(expectedResult, foo.arithmeticTriplets(nums, diff));
    }


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 4, 6, 7, 10}, 3, 2),
                Arguments.of(new int[]{4, 5, 6, 7, 8, 9}, 2, 2)
        );
    }

}
