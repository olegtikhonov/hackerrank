package test.twest.test.twest.hackerrank;

import java.util.Arrays;

public class InsertionSortPart2 {

    //-----------------------------------------------
    public static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }

        printArray(A);
    }

    public static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
    }


    //-----------------------------------------------


    public static void insertionSort2(int n, int[] arr) {
        // begin with 1
        for (int i = 1; i < n; i++) {
            for (int back = i; back > 0; back--) {
                if (arr[back] < arr[back - 1]) {
                    arr[back] = arr[back] ^ arr[back - 1];
                    arr[back - 1] = arr[back] ^ arr[back - 1];
                    arr[back] = arr[back] ^ arr[back - 1];
                }
            }
            System.out.println(Arrays.toString(arr).replace("[", "").replaceAll("]", "").replace(",", ""));
        }
    }
}
