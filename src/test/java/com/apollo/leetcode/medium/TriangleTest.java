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

public class TriangleTest implements ArgumentsProvider {

    private static Triangle foo;

    @BeforeAll
    public static void init() {
        foo = new Triangle();
    }

    @ParameterizedTest
    @ArgumentsSource(TriangleTest.class)
    public void test(List<List<Integer>> input, int expectedResult) {
        assertEquals(expectedResult, foo.minimumTotal(input));
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {

        return Stream.of(
                Arguments.of(
                        Arrays.asList(
                                Arrays.asList(2),
                                Arrays.asList(3, 4),
                                Arrays.asList(6, 5, 7),
                                Arrays.asList(4, 1, 8, 3)
                        ), 11
                ),
                Arguments.of(
                        Arrays.asList(
                                Arrays.asList(-10)
                        ), -10
                ),
                Arguments.of(
                        Arrays.asList(
                                Arrays.asList(-1),
                                Arrays.asList(2, 3),
                                Arrays.asList(1, -1, -3)
                        ), -1
                )
        );
    }
}
