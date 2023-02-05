package com.apollo.leetcode.medium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThresholdTest implements ArgumentsProvider {

    private static NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold foo;

    @BeforeAll
    public static void init() {
        foo = new NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold();
    }


    @ParameterizedTest
    @ArgumentsSource(NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThresholdTest.class)
    public void testTwo(int[] arr, int k, int threshold, int expectedResult) {
        assertEquals(expectedResult, foo.numOfSubarrays(arr, k, threshold));
    }


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4, 3),
                Arguments.of(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5, 6)
        );
    }
    
}
