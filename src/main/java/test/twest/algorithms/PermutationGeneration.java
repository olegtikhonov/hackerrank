package test.twest.algorithms;

import java.util.*;

public class PermutationGeneration {
    /* answer holder */
    private static List<String> permutations = new LinkedList<>();

    public static List<String> genPermutationHorowitzBook(String abc, int index, int lengthOfGeneration) {
        if (index == lengthOfGeneration) {
            permutations.add(abc);
        } else {
            for (int inx = 0; inx < lengthOfGeneration; inx++) {
                abc = swap(abc, index, inx);
                genPermutationHorowitzBook(abc, index + 1, lengthOfGeneration);
                abc = swap(abc, index + 1, inx);
            }
        }
        return permutations;
    }

    static String swap(String orig, int from, int to) {
        char[] local = orig.toCharArray();
        char tmp = local[from];
        local[from] = local[to];
        local[to] = tmp;
        return String.valueOf(local);
    }
}
