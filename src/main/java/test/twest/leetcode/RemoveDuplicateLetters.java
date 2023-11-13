package test.twest.leetcode;

import java.util.*;

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is
 * the smallest in lexicographical order
 * among all possible results.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bcabc"
 * Output: "abc"
 *
 * Example 2:
 *
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 104
 *     s consists of lowercase English letters.
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Set<Character> chartInSet = new HashSet<>();
        char[] chars = s.toCharArray();

        for(int inx = 0; inx < chars.length; inx++) {
            chartInSet.add(chars[inx]);
        }

        //Arrays.sort(chartInSet.toArray());
        return chartInSet.toString();
    }


}
