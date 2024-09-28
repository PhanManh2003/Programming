package view;

import entity.Counter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();

        // Create Counter object
        Counter counter = new Counter(input);
        
        // Count characters
        System.out.println("Character Count: { " + counter.getCharacterCount() + " }");
        
        // Count words
        System.out.println("Word Count: { " + counter.getWordCount() + " }");
    }
}
