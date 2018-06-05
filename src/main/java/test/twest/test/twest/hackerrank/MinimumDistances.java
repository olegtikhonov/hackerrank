package test.twest.test.twest.hackerrank;

/**
 * We define the distance between two array values as the number of indices between the two values. Given a,
 * find the minimum distance between any pair of equal elements in the array. If no such value exists, print -1.
 * For example, if a = [3, 2, 1, 2, 3], there are two matching pairs of values: 3 and 2.
 */
public class MinimumDistances {

    public static int minimumDistances(int[] a) {
        int localMinimum = Integer.MAX_VALUE;
        int localDistace = 0;

        for(int i = 0; i < a.length; i++) {
            for(int j = (i + 1); j < a.length; j++) {
                if(a[i] == a[j]) {
                    localDistace = j - i;
                    if(localMinimum > localDistace) {
                        localMinimum = localDistace;
                    }
                }
            }
        }
        return (localMinimum == Integer.MAX_VALUE) ? -1 : localMinimum;
    }
}
