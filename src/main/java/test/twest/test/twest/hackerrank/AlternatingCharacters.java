package test.twest.test.twest.hackerrank;

public class AlternatingCharacters {
    public static int alternatingCharacters(String s){
        int numberOfOperations = 0;
        char[] chars = s.toCharArray();
        int currentPointer = 0, counter = 0;

        for(int i = 1; i < chars.length; i++) {
            if(chars[currentPointer] == chars[i]) {
                numberOfOperations++;
            }
            currentPointer = i;
        }

        return numberOfOperations;
    }
}
