package test.twest.algorithms;

public class BubbleSort {

    /**
     * O(n^2)
     *
     * @param toSort
     *
     * @return
     */
    public static int[] bubble(int[] toSort) {
       for(int inx = 0; inx < toSort.length; inx++) {
           for (int jnx = inx + 1; jnx < toSort.length; jnx++) {
               if(toSort[jnx] < toSort[inx]) {
                   toSort[jnx] = toSort[jnx] ^ toSort[inx];
                   toSort[inx] = toSort[jnx] ^ toSort[inx];
                   toSort[jnx] = toSort[jnx] ^ toSort[inx];
               }
           }
       }
       return toSort;
    }
}
