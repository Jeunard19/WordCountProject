package word;

import word.interfaces.WordFrequency;
import word.interfaces.WordFrequencyAnalyzer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {
    @Override
    /**
     * Calculates the highest word frequency in text and returns the frequency.
     * @param text The input text.
     * @return Frequency as int.
     */
    public int calculateHighestFrequency(String text) {

        int frequency = Collections.max(this.getFrequencyMap(text).values()).intValue();

        return frequency;
    }

    @Override
    /**
     * Calculates the frequency of the provided word in String and returns the frequency.
     * @param text The input text.
     * @param word The word
     * @return Frequency as int.
     */
    public int calculateFrequencyForWord( String text, String word) {
        int  frequency = 0;
        try {// catch NullPointerException if word is not in text
            frequency = this.getFrequencyMap(text).get(word.toLowerCase()).intValue();
        } catch(NullPointerException e){
        }
        return frequency;
    }

    @Override
    /**
     * Calculates the frequency of each word in String and returns a list of most frequent n words.
     * @param text The input text.
     * @param n The amount of words
     * @return List with WordFrequency objects.
     */
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {

        List<WordFrequency> mostFrequentNWords = new ArrayList();
        Map<String, Long> frequencyMap = this.getFrequencyMap(text);

        //List containing the words as string
        List<String> mostFrequentWords = new ArrayList<>(frequencyMap.keySet());

        //Order the words by frequency and for the values with the same frequency, the order by ascendant alphabetical order.
        mostFrequentWords.sort(Comparator.comparingLong((String word) ->
                frequencyMap.get(word)).reversed().thenComparing(word -> word));

        if(n > mostFrequentWords.size()){
            //If n is larger thant the amount of words in the text, set n to the total number of words in the text
            n = mostFrequentWords.size();
        }

        //Get n words.
        mostFrequentWords.subList(0,n).forEach(word -> {
            mostFrequentNWords.add(new WordFrequencyImpl(word,frequencyMap.get(word).intValue()));
        });

        return mostFrequentNWords;
    }

    /**
     * Calculates the frequency of each word in String and returns a map with words as key
     * and the frequency as values.
     *
     * @param text The input text.
     * @return Map with words as key and the frequency as values.
     */
    private Map<String,Long> getFrequencyMap(String text) {
        // The \P{L}+ pattern will match one or more consecutive characters that are not letters in a Unicode context.
        return new ArrayList<>(Arrays.asList(text.split("\\P{L}+"))).stream().map(String::toLowerCase)
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ));
    }
}
