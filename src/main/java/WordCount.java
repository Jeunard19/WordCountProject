import word.Interfaces.WordFrequencyAnalyzer;
import word.WordFrequencyAnalyzerImpl;

public class WordCount {
    public static void main(String[] args){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        wordFrequencyAnalyzer.calculateMostFrequentNWords("The sun shines over over over a man the lake",3).forEach(wordFrequency -> {
            System.out.println(wordFrequency.getWord());
            System.out.println(wordFrequency.getFrequency());
        });


    }
}
