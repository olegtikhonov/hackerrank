package test.twest.algorithms;
import java.util.*;

/**
 * The idea to generate all possible permutations
 * checking for even or odd number
 * PROCEDURE HEAP(S,N)
 *   IF n == 1 THEN
 *     process S
 *   ELSE
 *     FOR i := 0 TO n - 1
 *     Heap(S, n - 1)
 *       IF n is even THEN
 *         swap S[0] and S[n - 1]
 *       ELSE
 *         swap S[i] and S[n - 1]
 *       END IF
 *    END FOR
 *   END IF
 * END PROCEDURE
 */
public class HeapsGenerator {
    private static List<String> permutations = new LinkedList<>();

    public static List<String> genPerms(String orig, int size) {
        if(size == 1) {
            permutations.add(orig);
        }
        for(int inx = 0; inx < size; inx++) {
            genPerms(orig, size -1);
            if(size % 2 == 0) {
                orig = swap(orig, 0, size -1);
            } else {
                orig = swap(orig, inx, size -1);
            }
        }
        return permutations;
    }

    private static String swap(String orig, int fromInx, int toInx) {
        char[] local = orig.toCharArray();
        char tmp = local[fromInx];
        local[fromInx] = local[toInx];
        local[toInx] = tmp;

        return String.valueOf(local);
    }
}
