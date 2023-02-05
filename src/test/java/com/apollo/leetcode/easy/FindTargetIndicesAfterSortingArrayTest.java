package com.apollo.leetcode.easy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTargetIndicesAfterSortingArrayTest implements ArgumentsProvider {

    private static FindTargetIndicesAfterSortingArray foo;

    @BeforeAll
    public static void init() {
        foo = new FindTargetIndicesAfterSortingArray();
    }

    @ParameterizedTest
    @ArgumentsSource(FindTargetIndicesAfterSortingArrayTest.class)
    public void test(int[] input, int target, List<Integer> expectedResult) {
        assertEquals(expectedResult, foo.targetIndices(input, target));
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 5, 2, 3}, 2, Arrays.asList(1, 2)),
                Arguments.of(new int[]{1, 2, 5, 2, 3}, 3, Arrays.asList(3)),
                Arguments.of(new int[]{1, 2, 5, 2, 3}, 5, Arrays.asList(4)),
                Arguments.of(new int[]{1, 2, 5, 2, 3}, 4, Collections.EMPTY_LIST),
                Arguments.of(new int[]{100, 1, 100}, 100, Arrays.asList(1, 2))
        );
    }
}
