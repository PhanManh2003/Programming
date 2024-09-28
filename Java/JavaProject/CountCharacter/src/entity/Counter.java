package entity;

import java.util.Arrays;

public class Counter {

    private String inputString;

    public Counter(String inputString) {
        this.inputString = inputString;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String[] countWords() {
        return inputString.split("\\s+");
    }

    public char[] countCharacters() {
        return inputString.replaceAll("\\s+", "").toCharArray();
    }

    public String getCharacterCount() {
        char[] characters = countCharacters();
        Arrays.sort(characters);

        StringBuilder charCount = new StringBuilder();
        char currentChar = characters[0];
        int count = 0;

        for (char c : characters) {
            if (c == currentChar) {
                count++;
            } else {
                charCount.append(currentChar).append("=").append(count).append(", ");
                currentChar = c;
                count = 1;
            }
        }
        charCount.append(currentChar).append("=").append(count);

        return charCount.toString();
    }

    public String getWordCount() {
        // get array
        String[] words = countWords();
        // sort
        Arrays.sort(words);

        // tạo string builder
        StringBuilder wordCount = new StringBuilder();
        String currentWord = words[0];
        int count = 0;

        // loop
        for (String word : words) {
            if (word.equals(currentWord)) {
                count++;
            } else {
                wordCount.append(currentWord).append("=").append(count).append(", ");
                currentWord = word;
                count = 1;
            }
        }
        // add thằng cuối
        wordCount.append(currentWord).append("=").append(count);

        return wordCount.toString();
    }
}
