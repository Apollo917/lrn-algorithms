package com.apollo.leetcode.easy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubstringsOfSizeThreeWithDistinctCharactersTest implements ArgumentsProvider {

    private static SubstringsOfSizeThreeWithDistinctCharacters foo;

    @BeforeAll
    public static void init() {
        foo = new SubstringsOfSizeThreeWithDistinctCharacters();
    }


    @ParameterizedTest
    @ArgumentsSource(SubstringsOfSizeThreeWithDistinctCharactersTest.class)
    public void test(String str, int expectedResult) {
        assertEquals(expectedResult, foo.countGoodSubstrings(str));
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of("xyzzaz", 1),
                Arguments.of("aababcabc", 4)
        );
    }

}
