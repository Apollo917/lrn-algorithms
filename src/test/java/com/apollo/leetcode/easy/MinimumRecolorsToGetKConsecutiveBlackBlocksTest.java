package com.apollo.leetcode.easy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumRecolorsToGetKConsecutiveBlackBlocksTest implements ArgumentsProvider {

    private static MinimumRecolorsToGetKConsecutiveBlackBlocks foo;

    @BeforeAll
    public static void init() {
        foo = new MinimumRecolorsToGetKConsecutiveBlackBlocks();
    }

    @ParameterizedTest
    @ArgumentsSource(MinimumRecolorsToGetKConsecutiveBlackBlocksTest.class)
    public void test(String blocks, int k, int expectedResult) {
        assertEquals(expectedResult, foo.minimumRecolors(blocks, k));
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of("WBBWWBBWBW", 7, 3),
                Arguments.of("WBWBBBW", 2, 0)
        );
    }
}
