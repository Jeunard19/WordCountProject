# Java Word Frequency Analyzer

This Java project provides an implementation of two interfaces, `WordFrequency` and `WordFrequencyAnalyzer`, to analyze and calculate word frequencies in a given text.

## Interfaces

### `WordFrequency`

This interface defines the following methods:

```java
String getWord();
int getFrequency();
```
- `getWord()`: Returns the word associated with the object that implements WordFrequency.
- `getFrequency()`: Returns the frequency of the word associated with the object that implements WordFrequency.

### WordFrequencyAnalyzer

This interface provides methods to calculate word frequencies and retrieve information from a given text:

```java
int calculateHighestFrequency(String text);
int calculateFrequencyForWord(String text, String word);
List<WordFrequency> calculateMostFrequentNWords(String text, int n);
```

- `calculateHighestFrequency(String text)`: Calculates and returns the highest frequency of any word in the given text.
- `calculateFrequencyForWord(String text, String word)`: Calculates and returns the frequency of a specific word in the given text.
- `calculateMostFrequentNWords(String text, int n)`: Calculates and returns a list of n most frequent words as WordFrequency objects in the given text.

### Usage
1. Download or clone the repository to your local machine.
2. Import the project into your preferred Java development environment.
3. Instantiate the implemented WordFrequencyAnalyzer class and use its methods to analyze word frequencies.

Here's an example of how to use the WordFrequencyAnalyzer:
```java
// Create a WordFrequencyAnalyzer instance
WordFrequencyAnalyzer analyzer = new WordFrequencyAnalyzerImpl();

// Calculate the highest frequency
int highestFrequency = analyzer.calculateHighestFrequency("The sun shines over over OveR a man the lake");

// Calculate the frequency for a specific word
int frequencyForWord = analyzer.calculateFrequencyForWord("The sun shines over over OveR a man the lake", "the");

// Calculate the most frequent N words
List<WordFrequency> mostFrequentNWords = analyzer.calculateMostFrequentNWords("The sun shines over over OveR a man the lake", 5);

// Print the results
System.out.println("Highest Frequency: " + highestFrequency);
System.out.println("Frequency for 'the': " + frequencyForWord);
System.out.println("Most Frequent 5 Words: ");
mostFrequentNWords.forEach(wordFrequency -> {
            System.out.println(wordFrequency.getWord());
            System.out.println(wordFrequency.getFrequency());
        });
```




