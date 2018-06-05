package test.twest.test.twest.hackerrank;


/**
 * Alice wrote a sequence of words in CamelCase as a string of letters, , having the following properties:
 * It is a concatenation of one or more words consisting of English letters.
 * All letters in the first word are lowercase.
 * For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
 *
 * Given , print the number of words in on a new line.
 */
public class CamelCase {

    public static int camelcase(String s) {
        int wordCounter = 1;

        for(int i = 0; i < s.length(); i++) {
            if(!Character.isLowerCase(s.charAt(i))) {
                ++wordCounter;
            }
        }

        return wordCounter;
    }
}
