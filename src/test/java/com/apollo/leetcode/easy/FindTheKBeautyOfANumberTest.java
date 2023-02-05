package com.apollo.leetcode.easy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTheKBeautyOfANumberTest implements ArgumentsProvider {

    private static FindTheKBeautyOfANumber foo;

    @BeforeAll
    public static void init() {
        foo = new FindTheKBeautyOfANumber();
    }


    @ParameterizedTest
    @ArgumentsSource(FindTheKBeautyOfANumberTest.class)
    public void test(int num, int k, int expectedResult) {
        assertEquals(expectedResult, foo.divisorSubstrings(num, k));
    }
    

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(240, 2, 2),
                Arguments.of(430043, 2, 2)
        );
    }

}
