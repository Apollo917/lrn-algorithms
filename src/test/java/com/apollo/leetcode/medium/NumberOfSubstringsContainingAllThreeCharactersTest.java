package com.apollo.leetcode.medium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfSubstringsContainingAllThreeCharactersTest implements ArgumentsProvider {

    private static NumberOfSubstringsContainingAllThreeCharacters foo;

    @BeforeAll
    public static void init() {
        foo = new NumberOfSubstringsContainingAllThreeCharacters();
    }


    @ParameterizedTest
    @ArgumentsSource(NumberOfSubstringsContainingAllThreeCharactersTest.class)
    public void testOne(String s, int expectedResult) {
        assertEquals(expectedResult, foo.numberOfSubstrings(s));
    }


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of("abcabc", 10),
                Arguments.of("aaacb", 3),
                Arguments.of("abc", 1)
        );
    }

}
