package word;

import word.interfaces.WordFrequency;

public class WordFrequencyImpl implements WordFrequency {
    private String word;
    private int frequency;


    @Override
    public String getWord() {
        return word;
    }

    @Override
    public int getFrequency() {
        return frequency;
    }

    public WordFrequencyImpl(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}
