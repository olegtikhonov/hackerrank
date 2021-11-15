package test.twest.algorithms;

/**
 * The idea:
 * for each element in the array we find the minimum element
 * when element is found we swap it with the correct place
 * We do here comparison by indices not by value, swap does.
 */
public class SelectionSort {
    public static void selectionSort(int[] toBeSorted) {
        for(int inx = 0; inx < toBeSorted.length; inx++) {
            int localMin = inx;

            for(int jnx = inx + 1; jnx < toBeSorted.length; jnx++) {
                if(less(toBeSorted[jnx], toBeSorted[localMin])) {
                    localMin = jnx;
                }
            }

            exchange(toBeSorted, inx, localMin);
        }
    }

    public static boolean less(int first, int second) {
        return first < second;
    }

    public static void exchange(int[] toBeSorted, int i, int min) {
        int local = toBeSorted[i];
        toBeSorted[i] = toBeSorted[min];
        toBeSorted[min] = local;
    }
}
