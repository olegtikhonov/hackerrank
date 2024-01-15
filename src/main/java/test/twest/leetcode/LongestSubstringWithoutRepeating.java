package test.twest.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int longestLen = 0, left = 0, right = 1;
        Set<Character> visited = new HashSet<>();
        // Input: s = "abcabcbb"
        if(s.isEmpty()) {
            return 0;
        }
        // we will visit all chars in string s
        while ((left < s.length())) {
            char charLeft = s.charAt(left);
            // when they are not equals
            while(visited.contains(charLeft)) {
                System.out.print("removing " + charLeft + " ");
                visited.remove(s.charAt(right));
                ++right;
            }
            visited.add(charLeft);
            ++left;
            longestLen = Math.max(longestLen, left - right + 1);
            System.out.println();
        }

        return longestLen;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeating longestSubstringWithoutRepeating = new LongestSubstringWithoutRepeating();
        int resutl = longestSubstringWithoutRepeating.lengthOfLongestSubstring(s);
        System.out.println(resutl);
    }
}

