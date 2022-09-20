package technical.interview.tasks.java8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LetterFrequencyCalculatorTest {

    @Test
    void test_shouldCalculateFrequency() {
        Map<String, Long> actual = new LetterFrequencyCalculator().calculateFrequency("Extraordinary");

        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("r", 3L);
        expected.put("a", 2L);
        expected.put("e", 1L);
        expected.put("x", 1L);
        expected.put("t", 1L);
        expected.put("o", 1L);
        expected.put("d", 1L);
        expected.put("i", 1L);
        expected.put("n", 1L);
        expected.put("y", 1L);

        assertEquals(expected, actual);
    }

    @Test
    void test_shouldCalculateFrequency2() {
        Map<String, Long> actual = new LetterFrequencyCalculator().calculateFrequency("A school of fish swam away from the swimmer");

        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("a", 4L);
        expected.put("s", 4L);
        expected.put("o", 4L);
        expected.put("m", 4L);
        expected.put("h", 3L);
        expected.put("f", 3L);
        expected.put("w", 3L);
        expected.put("i", 2L);
        expected.put("r", 2L);
        expected.put("e", 2L);
        expected.put("c", 1L);
        expected.put("l", 1L);
        expected.put("y", 1L);
        expected.put("t", 1L);

        assertEquals(expected, actual);
    }
}