

public class Palindrome {

    boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1)
            return true;

        if(s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }

        return false;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome("kayak"));
        System.out.println(palindrome.isPalindrome("today"));
    }

}
