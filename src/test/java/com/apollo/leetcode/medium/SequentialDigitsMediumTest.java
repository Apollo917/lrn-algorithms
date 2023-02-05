package com.apollo.leetcode.medium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequentialDigitsMediumTest implements ArgumentsProvider {

    private static SequentialDigits foo;

    @BeforeAll
    public static void init() {
        foo = new SequentialDigits();
    }

    @ParameterizedTest
    @ArgumentsSource(SequentialDigitsMediumTest.class)
    public void testOne(int low, int high, List<Integer> expectedResult) {
        assertEquals(expectedResult, foo.sequentialDigitsOne(low, high));
    }

    @ParameterizedTest
    @ArgumentsSource(SequentialDigitsMediumTest.class)
    public void testTwo(int low, int high, List<Integer> expectedResult) {
        assertEquals(expectedResult, foo.sequentialDigitsTwo(low, high));
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(100, 300, Arrays.asList(123, 234)),
                Arguments.of(1000, 13000, Arrays.asList(1234, 2345, 3456, 4567, 5678, 6789, 12345))
        );
    }
}
