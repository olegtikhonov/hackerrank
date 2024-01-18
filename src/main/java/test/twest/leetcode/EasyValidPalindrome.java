package test.twest.leetcode;

/**
 * Example 1:
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 * <p>
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 * <p>
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class EasyValidPalindrome {
    public boolean isPalindrome(String s) {
        // Let's remove all spaces
        s = s.trim().replaceAll(" ", "").replaceAll(",", "").replaceAll(":", "").toLowerCase();
        System.out.println("After transformation:=" + s);
        if(s == null) {
            return false;
        }

        int left = 0, right = s.length() - 1;
        char[] sAsCharArray = s.toCharArray();
        while(left <= right) {
            if(sAsCharArray[left] != sAsCharArray[right]) {
                return false;
            }
            ++left;
            --right;
        }

        return true;
    }

    public static void main(String[] args) {
        EasyValidPalindrome easyValidPalindrome = new EasyValidPalindrome();
        String example1 = "A man, a plan, a canal: Panama";
        boolean result = easyValidPalindrome.isPalindrome(example1);
        System.out.println("Result:=" + result);

        String example2 = "race a car";
        result = easyValidPalindrome.isPalindrome(example2);
        System.out.println("Result:=" + result);

        String example3 = " ";
        result = easyValidPalindrome.isPalindrome(example3);
        System.out.println("Result:=" + result);
    }
}
