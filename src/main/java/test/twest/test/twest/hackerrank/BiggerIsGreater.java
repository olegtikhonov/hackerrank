package test.twest.test.twest.hackerrank;

import java.util.*;

/**
 * Here I use Heap's algorithm to generate all permutations
 */
public class BiggerIsGreater {

    static Set<String> result = new HashSet<>();

    public static String permute(String w) {
        result.clear();
        generate(w.length(), w.toCharArray());
        String[] output = new String[result.size()];
        int i = 0;
        List<String> local = new ArrayList<>(result);
        Collections.sort(local);

        for (String item : local) {
            if(item.compareTo(w) >= 1) {
                return item;
            }
        }

        return "no answer";
    }


    private static void swap(char[] array, int firstIndx, int secondIndx) {
        char tmp;
        tmp = array[firstIndx];
        array[firstIndx] = array[secondIndx];
        array[secondIndx] = tmp;
    }

    /**
     * Heap's algorithms
     * https://en.wikipedia.org/wiki/Heap%27s_algorithm
     *
     * @param n
     * @param array
     */
    private static void generate(int n, char[] array) {
        if (n == 1) {
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < array.length; i++) {
                sb.append(array[i]);
            }
            result.add(sb.toString());
        } else {
            for (int inx = 0; inx < array.length; inx++) {
                generate(n - 1, array);
                if ((n % 2) == 0) {
                    swap(array, inx, (n - 1));
                } else {
                    swap(array, 0, (n - 1));
                }
            }
            generate(n - 1, array);
        }
    }

    static boolean nextPermutation(char[] array) {
        // Find longest non-increasing suffix
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        // Now i is the head index of the suffix

        // Are we at the last permutation already?
        if (i <= 0)
            return false;

        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j
        char temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        // Successfully computed the next permutation
        return true;
    }

    public static String biggerIsGreater(String w) {
//        result.clear();
//        char[] array = w.toCharArray();
//        calcualtePermutations(array);
//
//        List<String> local = new ArrayList<>(result);
//        Collections.sort(local);
//
//        for (String item : local) {
//            if(item.compareTo(w) >= 1) {
//                return item;
//            }
//        }
//
//        return "no answer";

        String next = findNext(w);
        return (next == null) ? "no answer" : next;

//        return (nextPermutation(array)) ? String.valueOf(array) : "no answer";
    }


    public static void calcualtePermutations(char[] array) {
        do {  // Must start at lowest permutation
            result.add(Arrays.toString(array));

        } while (nextPermutation(array));
    }

    static String findNext(String word) {
        int index = word.length() - 2;
        while (index >= 0 && word.charAt(index) >= word.charAt(index + 1)) {
            index--;
        }

        if (index < 0) {
            return null;
        }

        int biggerIndex = index + 1;
        while (biggerIndex + 1 < word.length() && word.charAt(biggerIndex + 1) > word.charAt(index)) {
            biggerIndex++;
        }

        StringBuilder next = new StringBuilder(word);
        swap(next, index, biggerIndex);
        reverse(next, index + 1, next.length() - 1);
        return next.toString();
    }

    static void swap(StringBuilder sb, int index1, int index2) {
        char temp = sb.charAt(index1);
        sb.setCharAt(index1, sb.charAt(index2));
        sb.setCharAt(index2, temp);
    }

    static void reverse(StringBuilder sb, int beginIndex, int endIndex) {
        for (int i = beginIndex, j = endIndex; i < j; i++, j--) {
            swap(sb, i, j);
        }
    }
}
