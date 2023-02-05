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

public class DesignBrowserHistoryTest implements ArgumentsProvider {

    private static DesignBrowserHistory foo;

    @BeforeAll
    public static void init() {
        foo = new DesignBrowserHistory();
    }

    @ParameterizedTest
    @ArgumentsSource(DesignBrowserHistoryTest.class)
    public void testBrowserHistoryOne(List<String> commands, List<String> args, List<String> expectedResult) {
        assertEquals(expectedResult, foo.useBrowserHistoryOne(commands, args));
    }

    @ParameterizedTest
    @ArgumentsSource(DesignBrowserHistoryTest.class)
    public void testBrowserHistoryTwo(List<String> commands, List<String> args, List<String> expectedResult) {
        assertEquals(expectedResult, foo.useBrowserHistoryTwo(commands, args));
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("BrowserHistory", "visit", "visit", "visit", "back", "back", "forward", "visit", "forward", "back", "back"),
                        Arrays.asList("leetcode.com", "google.com", "facebook.com", "youtube.com", "1", "1", "1", "linkedin.com", "2", "2", "7"),
                        Arrays.asList(null, null, null, null, "facebook.com", "google.com", "facebook.com", null, "linkedin.com", "google.com", "leetcode.com")
                )
        );
    }
}
