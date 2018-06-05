package test.twest.test.twest.hackerrank;

import java.util.Arrays;
import java.util.Collections;

/**
 * constrains: 1 <= n, k <= 100
 *             1 <= height[i] <= 100
 */
public class HurdleRace {
    /**
     *
     * @param k is a height of jumping
     * @param height - number of hurdles
     * @return number of potions. if the result is negative, return 0;
     */
    public static int hurdleRace(int k, int[] height) {
        // find a maximum of array
        int max = max(height);
        return (max - k) > 0 ? (max - k) : 0;
    }

    public static int max(int[] height) {
        int local = Integer.MIN_VALUE;
        for (Integer h: height) {
            if(h > local) {
                local = h;
            }
        }
        return local;
    }
}
