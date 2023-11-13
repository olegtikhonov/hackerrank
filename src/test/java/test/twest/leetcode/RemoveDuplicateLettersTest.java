package test.twest.leetcode;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class RemoveDuplicateLettersTest {

    @Disabled
    @Test
    public void testRemoveDuplicateLetters() {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        String s = "bcabc";
        String result = removeDuplicateLetters.removeDuplicateLetters(s);
        System.out.println(result);

        String second = "cbacdcbc";
        result = removeDuplicateLetters.removeDuplicateLetters(second);
        System.out.println(result);
    }
}