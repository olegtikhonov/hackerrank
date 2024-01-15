package test.twest.leetcode;

/**
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 */
public class EasyPalindromeNumber {
    public boolean isPalindrome(int x) {
        String numAsStr = String.valueOf(x);
        // if negative
        if(numAsStr.charAt(0) == '-') {
            return false;
        }

        int left = 0, right = numAsStr.length() - 1;
        while (left <= right) {
            if(numAsStr.charAt(left) == numAsStr.charAt(right)) {
                ++left;
                --right;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        EasyPalindromeNumber easyPalindromeNumber = new EasyPalindromeNumber();
        int firstCase = 101;
        System.out.println(easyPalindromeNumber.isPalindrome(firstCase));
    }
}
