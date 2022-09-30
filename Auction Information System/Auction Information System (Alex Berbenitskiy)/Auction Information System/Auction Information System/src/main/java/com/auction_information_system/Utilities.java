package com.auction_information_system;

/**
 * Utilities class.
 *
 * @author Dean Lonergan (20092570)
 */
public class Utilities {

    /**
     * Method to test if a String input contains a valid time.
     * @param time input String.
     * @return true if the input matches the time layout, false otherwise.
     */
    public static boolean validTime(String time) {
        return ((time.matches("[0-9]{2}[:][0-9]{2}")) && (!time.isBlank()));
    }

    /**
     * Method to test if a String input contains a valid phone number.
     * @param phone input String.
     * @return true if the input matches the appropriate phone number pattern, false otherwise.
     */
    public static boolean validPhone(String phone) {
        return ((phone.matches("[0-9]{10}")) && (!phone.isBlank()));
    }

    /**
     * Method to test if a String input contains fewer than 10 characters.
     * @param string input String.
     * @return true if the length of the string is less than 10, false otherwise.
     */
    public static boolean max100Chars(String string) {
        return string.length() <= 100;
    }

    /**
     * Method to test if a String input contains fewer than 50 characters.
     * @param string input String.
     * @return true if the length of the string is less than 50, false otherwise.
     */
    public static boolean max50Chars(String string) {
        return string.length() <= 50;
    }

    /**
     * Method to test if a String input contains fewer than 30 characters.
     * @param string input String.
     * @return true if the length of the string is less than 30, false otherwise.
     */
    public static boolean max30Chars(String string) {
        return string.length() <= 30;
    }
}
