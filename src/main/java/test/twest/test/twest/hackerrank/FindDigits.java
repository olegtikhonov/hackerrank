package test.twest.test.twest.hackerrank;


import java.util.Arrays;

public class FindDigits {
    public static int findDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int count = 0;

        for(int i = 0; i < chars.length; i++) {
            String cha = String.valueOf(chars[i]);
            if((Integer.valueOf(cha) != 0) && (n % Integer.valueOf(cha)) == 0) {
                ++count;
            }
        }

        return count;
    }
}
