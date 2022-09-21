package technical.interview.tasks.java8;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Task:   Find the frequency (number of occurrence) of every word in the given List of Strings!
 * Input:  List<String> which can have spaces. Examples: ["Apple", "Horse", "apple", "ApplE", "Minute", "masquerade", "Mask", "water", "Water"], ["Word", "A", "AA", "a", "aaa", "aa"], etc.
 * Output: Map<String, Long> where the key is the word and the value is the frequency.
 * <p>
 * Examples:
 * 1.
 * Input:   ["Apple", "Horse", "apple", "ApplE", "Minute", "masquerade", "Mask", "water", "Water"]
 * Output:  {APPLE=3, WATER=2, MASQUERADE=1, HORSE=1, MINUTE=1, MASK=1}
 * <p>
 * 2.
 * Input:   ["Word", "A", "AA", "a", "aaa", "aa"]
 * Output:  {AA=2, A=2, AAA=1, WORD=1}
 */
public class WordFrequencyCalculator {

    public Map<String, Long> calculateFrequency(List<String> words) {
        return words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingLong(Long::longValue).reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
    }
}
