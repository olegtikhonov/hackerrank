package test.twest.test.twest.hackerrank;

import java.util.TreeSet;

/**
 * Manasa is out on a hike with friends. She finds a trail of stones with numbers on them. She starts following the trail
 * and notices that any two consecutive stones' numbers differ by one of two values. Legend has it that there is a treasure
 * trove at the end of the trail. If Manasa can guess the value of the last stone, the treasure will be hers.
 *For example, assume she finds 2 stones and their differences are a = 2 or b = 3. We know she starts with a 0 stone not
 * included in her count. The permutations of differences for the two stones would be [2,2], [2,3], [3,2] or [3,3].
 * Looking at each scenario, stones might have [2,4], [2,5], [3,5] or [3,6] on them. The last stone might have any of 4, 5, or 6 on its face.
 * Task: Compute all possible numbers that might occur on the last stone given a starting stone with a 0 on it, a number of
 * additional stones found, and the possible differences between consecutive stones. Order the list ascending.
 *
 * Constrains: 1 <= n,a,b <= Math.pow(10,3)
 */
public class ManasaAndStones {

    public static int[] stones(int n, int a, int b) {
        TreeSet<Integer> finalStones = new TreeSet<Integer>();

        for (int i = 0; i < n; i++) {
            int sum = (i * a) + ((n - 1 - i) * b);
            finalStones.add(sum);
        }

        int[] resStones = new int[finalStones.size()];
        int i = 0;

        for (Integer e : finalStones) {
            resStones[i++] = e;
        }

        return  resStones;
    }
}
