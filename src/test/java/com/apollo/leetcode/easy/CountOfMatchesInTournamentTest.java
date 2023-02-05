package com.apollo.leetcode.easy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountOfMatchesInTournamentTest implements ArgumentsProvider {

    private static CountOfMatchesInTournament foo;

    @BeforeAll
    public static void init() {
        foo = new CountOfMatchesInTournament();
    }

    @ParameterizedTest
    @ArgumentsSource(CountOfMatchesInTournamentTest.class)
    public void test(int teamCount, int expectedResult) {
        assertEquals(expectedResult, foo.numberOfMatches(teamCount));
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(7, 6),
                Arguments.of(14, 13)
        );
    }
}
