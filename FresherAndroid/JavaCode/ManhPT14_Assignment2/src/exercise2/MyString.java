package exercise2;

public class MyString {

    private String text;

    public MyString() {
    }

    public MyString(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * Calculate sum of numbers
     */
    public int sumNumbers() {
        int sum = 0;
        String number = "";

        for (char ch : text.toCharArray()) {

            if (Character.isDigit(ch)) {
                number += ch; // còn thấy kí tự số thì append vào number
            } else { // khi kí tự ko còn là số thì bắt đầu cộng và reset biến number
                if (!number.isEmpty()) {
                    sum += Integer.parseInt(number);
                    number = "";
                }
            }
        }

        // Xử lí số ở cuối chuỗi
        if (!number.isEmpty()) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    /**
     * Find and print character with smallest ASCII code
     */
    public char smallestAsciiChar() {

        char min = text.charAt(0);

        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) < min) {
                min = text.charAt(i);
            }
        }

        return min;
    }

    /**
     * Find and print the capital letters in the string
     */
    public void printCapitalLetters() {

        System.out.print("Capital letters: ");

        for (char ch : text.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                System.out.print(ch + " ");
            }
        }

        System.out.println();
    }

    /**
     * Capitalize the first letters of the string
     */
    public String capitalizeFirstLetters() {
         // tách chuỗi thành các cụm kí tự cách nhau bởi khoảng trắng
        String[] words = text.split("\\s+");
        String result = "";

        for (String word : words) {

            if (!word.isEmpty()) {
                result += Character.toUpperCase(word.charAt(0))
                        + word.substring(1).toLowerCase()
                        + " ";
            }
        }

        return result.trim();
    }

    /**
     * Print the reversed string
     */
    public String reverseString() {

        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }

        return reversed;
    }
}
