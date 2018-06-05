package test.twest.test.twest.hackerrank;

import java.util.BitSet;

/**
 * Flatland is a country with a number of cities, some of which have space stations. Cities are numbered consecutively
 * and each has a road of length connecting it to the next city. It is not a circular route, so the first city doesn't
 * connect with the last city. Determine the maximum distance from any city to it's nearest space station.
 */
public class FlatlandSpaceStations {

    public static int flatlandSpaceStations(int n, int[] c) {
        BitSet b = new BitSet(n);
        // Initializes the set.
        for (int i = 0; i < c.length; i++) {
            b.set(c[i]);
        }

        int start = 0;
        int finish = b.nextSetBit(0);
        int max = finish - start;

        do {
            max = Math.max(max, (finish - start) / 2);
            start = finish;
            finish = b.nextSetBit(start + 1);

        } while (finish > -1);

        max = Math.max(max, n - 1 - start);
        System.out.print(max);

        return max;
    }
}
