package test.twest.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Manachar’s Algorithm
 * take a String and add #
 * for example, abababa -> #a#b#a#b#a#b#a#
 *                    P ->
 * One way (Set 2) to find a palindrome is to start from the center of the string and compare characters in both
 * directions one by one.
 *
 * {@link 'https://www.youtube.com/watch?v=1ir1eryUr80'}
 */
public class LongestPalindrimicSubstring {
    // A function to print a substring.
    static void printSubstring(String str, int left, int right){
        for (int i = left; i <= right; i++) {
            System.out.print(str.charAt(i));
        }
    }

    // Implementation of Manacher's Algorithm
    public static void longestPalSubstring(String s) {
        /*
         If length of given string is n then its length after
         inserting n+1 "#", one "@", and one "$" will be
         (n) + (n+1) + (1) + (1) = 2n+3
        */
        int strLen = 2 * s.length() + 3;
        char[] sChars = new char[strLen];

        /*
         Inserting special characters to ignore special cases
         at the beginning and end of the array
         "abc" -> @ # a # b # c # $
         "" -> @#$
         "a" -> @ # a # $
        */
        sChars[0] = '@';
        sChars[strLen - 1] = '$';
        int t = 1;
        for (char c : s.toCharArray()) {
            sChars[t++] = '#';
            sChars[t++] = c;
        }
        sChars[t] = '#';

        int maxLen = 0;
        int start = 0;
        int maxRight = 0;
        int center = 0;
        int[] p = new int[strLen]; // i's radius, which doesn't include i
        for (int i = 1; i < strLen - 1; i++) {
            if (i < maxRight) {
                p[i] = Math.min(maxRight - i, p[2 * center - i]);
            }

            // Expanding along the center
            while (sChars[i + p[i] + 1] == sChars[i - p[i] - 1]) {
                p[i]++;
            }

            // Updating center and its bound
            if (i + p[i] > maxRight) {
                center = i;
                maxRight = i + p[i];
            }

            // Updating ans
            if (p[i] > maxLen) {
                start = (i - p[i] - 1) / 2;
                maxLen = p[i];
            }
        }

        // Printing the longest Palindromic substring
        System.out.print("The Longest Palindromic Substring is: ");
        printSubstring(s, start, start + maxLen - 1);
    }



    public static void main(String[] args) {
        String input = "abababa";
        longestPalSubstring(input);

        System.out.println("len is " + "PAYPALISHIRING".length());
    }
}
