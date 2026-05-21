package fa.training.utils;

public class Validator {

    /**
     * Validate ISBN format ISBN must be 10-17 characters long and contain only
     * digits and hyphens Example: 678-3-16-1486
     *
     * @param isbn ISBN string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidIsbn(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            return false;
        }

        // Check length (10-17 characters)
        if (isbn.length() < 10 || isbn.length() > 17) {
            return false;
        }

        // Check if contains only digits and hyphens
        if (!isbn.matches("[0-9\\-]+")) {
            return false;
        }

        // Check if has at least some digits
        if (!isbn.matches(".*\\d.*")) {
            return false;
        }

        return true;
    }

    /**
     * Validate if a number is positive
     */
    public static boolean isPositive(int number) {
        return number > 0;
    }

    /**
     * Validate if a string is not empty
     */
    public static boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
