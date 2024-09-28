package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validator {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Validator() {
    }

    public static int getInt(String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            int min, int max) {
        do {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println(messageErrorOutOfRange);
                }
            } catch (Exception e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }

    public static double getDouble(
            String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorInvalidNumber,
            double min, double max) {
        do {
            try {
                System.out.print(messageInfo);
                double number = Double.parseDouble(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }

    public static String getString(String messageInfo, String messageError, 
            final String REGEX) {
        do {
            System.out.print(messageInfo);
            String str = SCANNER.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);

    }

    public static Date getDate(String messageInfo,
            String messageErrorOutOfRange,
            String messageErrorDate, final String REGEX,
            Date min, Date max) {

        //Converting a Date object into a string, based on a specified pattern.
        SimpleDateFormat dateFormat = new SimpleDateFormat(REGEX);
        // Specify whether or not date/time parsing is to be lenient. With lenient parsing, the parser may use heuristics to interpret inputs that do not precisely match this object's format. With strict parsing, inputs must match this object's format.
        dateFormat.setLenient(false);
        do {
            System.out.print(messageInfo);
            try {
                // Parse a string back into a Date object
                Date date = dateFormat.parse(SCANNER.nextLine());
                if (date.compareTo(min) >= 0 && date.compareTo(max) <= 0) {
                    return date;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (Exception e) {
                System.out.println(messageErrorDate);
            }
        } while (true);
    }

}
