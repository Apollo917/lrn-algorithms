package com.apollo.leetcode.medium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerWithMostWaterTest implements ArgumentsProvider {

    private static ContainerWithMostWater foo;

    @BeforeAll
    public static void init() {
        foo = new ContainerWithMostWater();
    }

    @ParameterizedTest
    @ArgumentsSource(ContainerWithMostWaterTest.class)
    public void test(int[] input, int expectedResult) {
        assertEquals(expectedResult, foo.maxArea(input));
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{1, 1}, 1)
        );
    }
}
