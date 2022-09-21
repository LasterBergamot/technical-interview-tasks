package technical.interview.tasks.java8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WordFrequencyCalculatorTest {

    @ParameterizedTest
    @MethodSource("wordFrequencyMethodSource")
    void test_shouldCalculateFrequency(List<String> input, Map<String, Long> expected) {
        Map<String, Long> actual = new WordFrequencyCalculator().calculateFrequency(input);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> wordFrequencyMethodSource() {
        Map<String, Long> first = new LinkedHashMap<>();
        first.put("APPLE", 3L);
        first.put("WATER", 2L);
        first.put("MASQUERADE", 1L);
        first.put("HORSE", 1L);
        first.put("MINUTE", 1L);
        first.put("MASK", 1L);

        Map<String, Long> second = new LinkedHashMap<>();
        second.put("AA", 2L);
        second.put("A", 2L);
        second.put("AAA", 1L);
        second.put("WORD", 1L);

        return Stream.of(
                Arguments.of(
                        Arrays.asList("Apple", "Horse", "apple", "ApplE", "Minute", "masquerade", "Mask", "water", "Water"),
                        first
                ),
                Arguments.of(
                        Arrays.asList("Word", "A", "AA", "a", "aaa", "aa"),
                        second
                )
        );
    }

    @ParameterizedTest
    @MethodSource("oddWordFrequencyMethodSource")
    void test_shouldCalculateOddFrequency(List<String> input, Map<String, Long> expected) {
        Map<String, Long> actual = new WordFrequencyCalculator().calculateOddFrequency(input);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> oddWordFrequencyMethodSource() {
        Map<String, Long> first = new LinkedHashMap<>();
        first.put("APPLE", 3L);
        first.put("MASQUERADE", 1L);
        first.put("HORSE", 1L);
        first.put("MINUTE", 1L);
        first.put("MASK", 1L);

        Map<String, Long> second = new LinkedHashMap<>();
        second.put("AAA", 1L);
        second.put("WORD", 1L);

        return Stream.of(
                Arguments.of(
                        Arrays.asList("Apple", "Horse", "apple", "ApplE", "Minute", "masquerade", "Mask", "water", "Water"),
                        first
                ),
                Arguments.of(
                        Arrays.asList("Word", "A", "AA", "a", "aaa", "aa"),
                        second
                )
        );
    }
}