package com.apollo.leetcode.easy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumNumberOfWordsFoundInSentencesTest implements ArgumentsProvider {

    private static MaximumNumberOfWordsFoundInSentences foo;

    @BeforeAll
    public static void init() {
        foo = new MaximumNumberOfWordsFoundInSentences();
    }

    @ParameterizedTest
    @ArgumentsSource(MaximumNumberOfWordsFoundInSentencesTest.class)
    public void test(String[] sentences, int expectedResult) {
        assertEquals(expectedResult, foo.mostWordsFound(sentences));
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"}, 6),
                Arguments.of(new String[]{"please wait", "continue to fight", "continue to win"}, 3)
        );
    }
}
