package com.apollo.leetcode.medium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AngleBetweenHandsOfAClockTest implements ArgumentsProvider {

    private static AngleBetweenHandsOfAClock foo;

    @BeforeAll
    public static void init() {
        foo = new AngleBetweenHandsOfAClock();
    }


    @ParameterizedTest
    @ArgumentsSource(AngleBetweenHandsOfAClockTest.class)
    public void test(int hour, int minutes, double expectedResult) {
        assertEquals(expectedResult, foo.angleClock(hour, minutes));
    }


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(12, 30, 165),
                Arguments.of(3, 30, 75),
                Arguments.of(3, 15, 7.5)
        );
    }

}
