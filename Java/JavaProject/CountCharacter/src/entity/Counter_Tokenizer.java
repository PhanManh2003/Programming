package entity;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Counter_Tokenizer {

    private String inputString;

    public Counter_Tokenizer(String inputString) {
        this.inputString = inputString;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public HashMap<String, Integer> countWords() {
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        // Sử dụng StringTokenizer để tách chuỗi thành các từ
        StringTokenizer tokenizer = new StringTokenizer(inputString);

        // Đếm số lần xuất hiện của mỗi từ
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        return wordCountMap;
    }

    public HashMap<Character, Integer> countCharacters() {
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Sử dụng StringTokenizer để tách chuỗi thành các ký tự
        StringTokenizer tokenizer = new StringTokenizer(inputString, " ", false);

        // Đếm số lần xuất hiện của mỗi ký tự
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            for (char c : token.toCharArray()) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
        }

        return charCountMap;
    }

    public int getTotalCharacters(HashMap<Character, Integer> charCountMap) {
        int total = 0;
        for (int count : charCountMap.values()) {
            total += count;
        }
        return total;
    }

    public int getTotalWords(HashMap<String, Integer> wordCountMap) {
        int total = 0;
        for (int count : wordCountMap.values()) {
            total += count;
        }
        return total;
    }
}
