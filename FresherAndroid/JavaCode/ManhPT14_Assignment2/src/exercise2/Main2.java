package exercise2;

public class Main2 {

    public static void main(String[] args) {
        MyString myStr = new MyString("abc123Tdf456kmn1");
        // test: Calculate sum of numbers
        System.out.println(myStr.sumNumbers()); // expected: 580
        
        // test: Find and print character with smallest ASCII code\
        System.out.println(myStr.smallestAsciiChar()); // expected: 1
        
        // test: Find and print the capital letters in the string
        myStr.printCapitalLetters();
        
        // test: Capitalize the first letters of the string
        System.out.println(myStr.capitalizeFirstLetters()); // expected: Abc123Tdf456kmn1 Xyz
        
        // test: Print the reversed string
        System.out.println(myStr.reverseString()); // expected: 1nmk654fdT321cba
    }
}
