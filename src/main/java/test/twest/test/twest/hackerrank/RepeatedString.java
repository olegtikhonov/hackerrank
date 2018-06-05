package test.twest.test.twest.hackerrank;


import java.util.ArrayList;

/**
 * Lilah has a string, S, of lowercase English letters that she repeated infinitely many times.
 * Given an integer,N , find and print the number of letter a's in the first letters of Lilah's infinite string.
 * For example, if the string s='abcac' and n=10, the substring we consider is 'abcacabcac', the first 10 characters of her infinite string.
 * There are 4 occurrences of a in the substring.
 */
public class RepeatedString {
    static class CircularList<E> extends ArrayList<E> {
        @Override
        public E get(int index) {
            return super.get(index % size());
        }
    }

    public static long repeatedString(String s, long n) {
        // algo is very simple
        // first step - calculate number of a in a sample
        int localCounter = 0;
        for(char c : s.toCharArray()) {
            if(c == 'a') {
                localCounter++;
            }
        }
        // second step - how many parts in big n
        long divider = n / s.toCharArray().length;
        int divisor = (int) (n % s.toCharArray().length);

        long result = localCounter * divider;
        localCounter = 0;
        char[] charArray = s.toCharArray();
        for(int i = 0; i < divisor; i++) {
            if(charArray[i] == 'a') {
                localCounter++;
            }
        }

        return result + localCounter;
    }
}
