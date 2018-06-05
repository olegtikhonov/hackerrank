package test.twest.test.twest.hackerrank;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * The first step to find all possible pairs
 */
public class DivisibleSumPairs {
    //The first step to find all possible pairs

    /**
     *
     * @param n integers in array
     * @param k divisor
     * @param ar
     * @return
     */
    public static int divisibleSumPairs(int n, int k, int[] ar) {
        int count = 0;
        // Complete this function
        for (int row = 0; row < n; row++ ) {
            for (int col = row + 1; col < n; col++ ) {
                if(((ar[row] + ar[col]) % k) == 0) {
                    count++;
                    //System.out.println("i=" + row + ", j=" + col + " --> " + (ar[row] + ar[col]));
                }
            }
        }
        return count;
    }
}
