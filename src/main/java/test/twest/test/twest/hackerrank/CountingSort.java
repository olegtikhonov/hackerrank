package test.twest.test.twest.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {
    // complexity: O(4n) = O(n)
    public static int[] countingSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        // First step - find max
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        // Step 2, create a new array of max elements + 1
        int[] tmp = new int[max + 1];
        int currentIndex;

        for(int i = 0; i < arr.length; i++) {
            currentIndex = arr[i];
            tmp[currentIndex]++;
        }
        // Step 3, just put all relevant numbers into array
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < tmp.length; i++) {
            if(tmp[i] != 0) {
                for(int j = 0; j < tmp[i]; j++) {
                    numbers.add(i);
                }
            }
        }

        int[] integers = new int[numbers.size()];
        // Step 4 converts a list to int[]
        for (int i = 0; i < integers.length; i++) {
            integers[i] = numbers.get(i);
        }


        return integers;
    }
}
