package test.twest.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class CommonLongestPrefix {
    public String longestCommonPrefix(String[] strs) {
        // "flower","flow","flight"
        char[] wordAsChar = strs[0].toCharArray();
        Set<Character> longestPrefix = new HashSet<>();
        for(int inx = 0; inx < wordAsChar.length; inx++) {
            for(int word = 1; word < strs.length; word++) {
                if(inx > strs[word].length()  || wordAsChar[inx] != strs[word].charAt(inx)) {
                    return longestPrefix.toString();
                }
            }
            // if exists then add to Set
            longestPrefix.add(wordAsChar[inx]);
        }

        return longestPrefix.toString();
    }

    public static void main(String[] args) {
        CommonLongestPrefix commonLongestPrefix = new CommonLongestPrefix();
        String result = commonLongestPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(result);

        //
        result = commonLongestPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"});
        System.out.println(result);
    }
}
