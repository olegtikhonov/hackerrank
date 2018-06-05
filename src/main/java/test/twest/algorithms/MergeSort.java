package test.twest.algorithms;

/**
 * Merge sort sorts a subarray array[a. . .b] as follows:
 *  If a = b , do not do anything, because the subarray is already sorted.
 *  Calculate the position of the middle element: k=|(a+b)/2| - low bound
 *  Recursively sort the subarray array[a. . .k].
 *  Recursively sort the subarray array[k+1 . . .b].
 *  Merge the sorted subarrays array[a . . . k] and array[k + 1 . . . b] into a sorted subarray array[a . . . b]
 *
 *  Time complexity: O(N Log N)
 */
public class MergeSort {

    /**
     * Sorts array using merge sort algorithm.
     *
     * @param array to be sorted.
     */
    public static void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length -1);
    }

    /**
     * Recursive merge sort.
     * @param array
     * @param forMerge
     * @param leftStart
     * @param rightStart
     */
    private static void mergeSort(int[] array, int[] forMerge, int leftStart, int rightStart) {
        // base case: If a = b , do not do anything, because the subarray is already sorted.
        if(leftStart >= rightStart) {
            return;
        }
        // Calculate the position of the middle element: k=|(a+b)/2| - low bound
        int middle = (leftStart + rightStart) / 2;
        // sort left half
        mergeSort(array, forMerge, leftStart, middle);
        // sort right half
        mergeSort(array, forMerge, middle + 1, rightStart);
        // merge halves
        mergeHalves(array, forMerge, leftStart, rightStart);
    }

    /**
     * Most important task of merge sort.
     *
     * @param array the original array
     * @param forMerge a temporary array for the copy of each half
     * @param leftStart starting offset
     * @param rightEnd ending offset
     */
    private static void mergeHalves(int[] array, int[] forMerge, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;
        int left = leftStart, right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if(array[left] <= array[right]) {
                forMerge[index] = array[left];
                left++;
            }else {
                forMerge[index] = array[right];
                right++;
            }
            index++;
        }
        // copy left half of array
        System.arraycopy(array, left, forMerge, index, leftEnd - left + 1);
        // copy right half of array
        System.arraycopy(array, right, forMerge, index, rightEnd - right + 1);
        // merge back to original array
        System.arraycopy(forMerge, leftStart, array, leftStart, size);
    }
}
