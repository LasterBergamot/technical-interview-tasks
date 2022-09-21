package technical.interview.tasks.java8;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Task:   Find the frequency (number of occurrence) of every letter in the given String!
 * Input:  String which can have spaces. Examples: "Extraordinary", "A school of fish swam away from the swimmer", etc.
 * Output: Map<String, Long> where the key is the letter and the value is the frequency.
 * <p>
 * Examples:
 * 1.
 * Input:   "Extraordinary"
 * Output:  {r=3, a=2, e=1, x=1, t=1, o=1, d=1, i=1, n=1, y=1}
 * <p>
 * 2.
 * Input:   "A school of fish swam away from the swimmer"
 * Output:  {a=4, s=4, o=4, m=4, h=3, f=3, w=3, i=2, r=2, e=2, c=1, l=1, y=1, t=1}
 */
public class LetterFrequencyCalculator {

    public Map<String, Long> calculateFrequency(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .map(Object::toString)
                .filter(letter -> !letter.contains(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingLong(Long::longValue).reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
    }
}
