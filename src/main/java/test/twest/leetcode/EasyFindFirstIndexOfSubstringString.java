package test.twest.leetcode;

/**
 * Example 1:
 * <p>
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * <p>
 * Example 2:
 * <p>
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * <p>
 * {@link 'https://www.youtube.com/watch?v=JoF0Z7nVSrA'}
 */
public class EasyFindFirstIndexOfSubstringString {
    public int strStr(String haystack, String needle) {
        // brute force approach
        for(int inx = 0; inx < haystack.length(); inx++) {
            for(int j = 0; j < needle.length(); j++) {

                if(haystack.charAt(inx + j) != needle.charAt(j)) {
                    break;
                }

                if(j == needle.length() - 1) {
                    System.out.println("Found at index " + inx);
                    return inx;
                }
            }
        }
        System.out.println("Not found at index");
        return -1;
    }



    public static void main(String[] args) {
        EasyFindFirstIndexOfSubstringString easyFindFirstIndexOfSubstringString = new EasyFindFirstIndexOfSubstringString();
        String haystack = "leetcode";
        String needle = "leeto";
        //int[] pat = easyFindFirstIndexOfSubstringString.computeLPSArray(needle);
        easyFindFirstIndexOfSubstringString.strStr(haystack, needle);

        haystack = "sadbutsad";
        needle = "adbu";
        //int[] pat = easyFindFirstIndexOfSubstringString.computeLPSArray(needle);
        easyFindFirstIndexOfSubstringString.strStr(haystack, needle);

    }
}
