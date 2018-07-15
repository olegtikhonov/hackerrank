package test.twest.test.twest.hackerrank;


/**
 * Given an array of integers, can you sort an array in ascending order using only one of the following operations one time?
 *
 *     Swap two elements.
 *     Reverse one sub-segment.
 *
 * If either one would work, choose swap over reverse. For instance, given an array we can swap the and , or reverse them. We choose swap.
 * @link https://www.hackerrank.com/challenges/almost-sorted/problem
 */
public class AlmostSorted {

    enum status {yes, no, swap, reverse};

    public static void almostSorted(int[] arr) {
        int i, j;
        // case 1:
        if (arr.length < 2) {
            System.out.println(status.yes.name());
        }
        // case 2:
        if (isAsc(arr)) {
            System.out.println(status.yes.name());
            return;
        }
        // look at breaking order of the arr
        for (i = 0; i < arr.length - 1 && arr[i] < arr[i + 1]; ++i) ;
        for (j = arr.length - 1; j > 0 && arr[j - 1] < arr[j]; --j) ;

        // try swap
        swap(arr, i, j);
        if (isAsc(arr)) {
            System.out.println(status.yes.name() + "\n" + status.swap.name() + " " + (i+1) + " " + (j+1));
            return;
        }
        // try reverse (continue reversing inner pairs)
        int k = i+1, l = j-1;
        while (k < l) swap(arr, k++, l--);
        if (isAsc(arr)) {
            System.out.println(status.yes.name() + "\n" + status.reverse.name() + " " + (i+1) + " " + (j+1));
            return;
        }
        System.out.println(status.no.name());
    }

    public static void swap(int[] d, int i, int j) {
        int tmp = d[i];
        d[i] = d[j];
        d[j] = tmp;
    }

    public static boolean isAsc(int[] d) {
        for (int i = 0; i < d.length-1; ++i) {
            if (d[i] > d[i+1]) return false;
        }
        return true;
    }
}
