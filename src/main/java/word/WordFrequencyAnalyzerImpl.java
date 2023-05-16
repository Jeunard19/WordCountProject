package word;

import word.Interfaces.WordFrequency;
import word.Interfaces.WordFrequencyAnalyzer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {
    @Override
    public int calculateHighestFrequency(String text) {

        int frequency = Collections.max(this.getFrequencyMap(text).values()).intValue();

        return frequency;
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {

        int frequency = this.getFrequencyMap(text).get(word).intValue();

        return frequency;
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {

        List<WordFrequency> mostFrequentNWords = new ArrayList<>();
        Map<String, Long> frequencyMap = this.getFrequencyMap(text);
        List<String> mostFrequentWords = new ArrayList<>(frequencyMap.keySet());

        mostFrequentWords.sort(Comparator.comparingLong((String word) ->
                frequencyMap.get(word)).reversed().thenComparing(word -> word));


        mostFrequentWords.subList(0,n).forEach(word -> {
            mostFrequentNWords.add(new WordFrequencyImpl(word,frequencyMap.get(word).intValue()));
        });

        return mostFrequentNWords;
    }

    private Map<String,Long> getFrequencyMap(String text) {
        return new ArrayList<>(Arrays.asList(text.split("\\P{L}+"))).stream()
                .map(String::toLowerCase)
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ));
    }
}
