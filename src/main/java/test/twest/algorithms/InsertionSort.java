package test.twest.algorithms;

/**
 * The idea:
 * when insert element into array, we try to find the correct place for it by swapping the elements.
 */
public class InsertionSort {
    public static void insertionSort(int[] toBeSorted) {
        for(int inx = 0; inx < toBeSorted.length; inx++) {
            for(int jnx = inx; jnx > 0; jnx--) {
                if(less(toBeSorted[jnx], toBeSorted[jnx - 1])) {
                    exchange(toBeSorted, jnx, jnx - 1);
                }
                else {
                    break;
                }
            }
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
