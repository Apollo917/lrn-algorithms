package com.apollo.leetcode.easy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordsInAStringIIITest implements ArgumentsProvider {

    private static ReverseWordsInAStringIII foo;

    @BeforeAll
    public static void init() {
        foo = new ReverseWordsInAStringIII();
    }


    @ParameterizedTest
    @ArgumentsSource(ReverseWordsInAStringIIITest.class)
    public void test(String s, String expectedResult) {
        assertEquals(expectedResult, foo.reverseWords(s));
    }


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of("Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc"),
                Arguments.of("God Ding", "doG gniD")
        );
    }

}
