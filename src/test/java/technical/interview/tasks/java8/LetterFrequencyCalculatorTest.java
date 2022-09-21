package technical.interview.tasks.java8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LetterFrequencyCalculatorTest {

    @ParameterizedTest
    @MethodSource("letterFrequencyMethodSource")
    void test_shouldCalculateFrequency(String input, Map<String, Long> expected) {
        Map<String, Long> actual = new LetterFrequencyCalculator().calculateFrequency(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> letterFrequencyMethodSource() {
        Map<String, Long> extraordinary = new LinkedHashMap<>();
        extraordinary.put("r", 3L);
        extraordinary.put("a", 2L);
        extraordinary.put("e", 1L);
        extraordinary.put("x", 1L);
        extraordinary.put("t", 1L);
        extraordinary.put("o", 1L);
        extraordinary.put("d", 1L);
        extraordinary.put("i", 1L);
        extraordinary.put("n", 1L);
        extraordinary.put("y", 1L);

        Map<String, Long> schoolOfFish = new LinkedHashMap<>();
        schoolOfFish.put("a", 4L);
        schoolOfFish.put("s", 4L);
        schoolOfFish.put("o", 4L);
        schoolOfFish.put("m", 4L);
        schoolOfFish.put("h", 3L);
        schoolOfFish.put("f", 3L);
        schoolOfFish.put("w", 3L);
        schoolOfFish.put("i", 2L);
        schoolOfFish.put("r", 2L);
        schoolOfFish.put("e", 2L);
        schoolOfFish.put("c", 1L);
        schoolOfFish.put("l", 1L);
        schoolOfFish.put("y", 1L);
        schoolOfFish.put("t", 1L);

        return Stream.of(
                Arguments.of("Extraordinary", extraordinary),
                Arguments.of("A school of fish swam away from the swimmer", schoolOfFish)
        );
    }
}