package test.twest.test.twest.hackerrank;


public class MakingAnagrams {

    public static int makingAnagrams(String s1, String s2){
        int numberOfDeletion = 0;

        int[] chars = new int[26];

        for (char c1 : s1.toCharArray()) {
            chars[c1 - 97]++;
        }

        for (char c2 : s2.toCharArray()) {
            chars[c2 - 97]--;
        }

        for (int i : chars) {
            numberOfDeletion += Math.abs(i);
        }

        return numberOfDeletion;
    }
}
