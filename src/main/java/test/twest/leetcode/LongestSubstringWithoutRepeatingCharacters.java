package test.twest.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Solution is a sliding window
 * Two pointers and Set of already seen characters
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0, right = 0;
        Set<Character> visited = new HashSet<>();

        // Check the validity of input
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Go through the S
        while(left < s.length()) {
            // Get the char from the String
            char tmp = s.charAt(left);
            // Check if it is seen already
            while(visited.contains(tmp)) {
                visited.remove(s.charAt(right));
                ++right;
            }
            // Put a char into the Set
            visited.add(tmp);
            // Find the max
            max = Math.max(max, left - right + 1);
            // Increase the left pointer
            ++left;
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        String input = "awsxccdsa";
        int result = lswrc.lengthOfLongestSubstring(input);
        System.out.println("The len of longest substring is " + result);

        input = "sssssss";
        System.out.println("The len of longest substring is " + lswrc.lengthOfLongestSubstring(input));
    }
}
