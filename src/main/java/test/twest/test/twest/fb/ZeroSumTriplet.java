package test.twest.test.twest.fb;

import java.util.Arrays;

/**
 * Find all triplets with zero sum.
 * Given an array of distinct elements. The task is to find triplets in the array whose sum is zero.
 *
 * <code>
 *     Input : arr[] = {0, -1, 2, -3, 1}
 *     Output : (0 -1 1), (2 -3 1)
 * </code>
 * The idea is to sort array and have three pointers.
 * If a sum of three pointers equals to z, print the values of the array
 * if a sum of them is less than zero, increase the left pointer
 * if a sum of them is greater than zero, decrease the right pointer
 */
public class ZeroSumTriplet {
    private boolean isFound;

    public void findTriplets(int arr[], int n) {
        // variable initialization
        int sum = 0;
        // Step 1: sort the array
        Arrays.sort(arr);

        for (int indx = 0; indx < arr.length - 1; indx++) {
            int left = indx + 1;
            int right = n - 1;
            int x = arr[indx];

            while (left < right) {
                sum = x + arr[left] + arr[right];
                if (sum == 0) {
                    System.out.println("" + x + " " + arr[left] + " " + arr[right]);
                    // shift pointers
                    left++;
                    right--;
                    isFound = true;
                }
                // two cases 1 - If sum of three elements is less than zero then increment in left direction
                //           2 - If sum of three elements is greater than zero then decrease in right direction
                else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        if(!isFound) {
            System.out.println("No triple is found so far.");
        }
    }
}
