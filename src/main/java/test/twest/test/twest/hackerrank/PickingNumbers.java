package test.twest.test.twest.hackerrank;

import java.util.Arrays;

public class PickingNumbers {
    // the algo:
    // 1. Arrays.sort()
    // 2. go throu the sorted array and find indices between minimum and the next minimum
    // approach "runner"
    static int getMaxSet(int arr[], int n) {
        Arrays.sort(arr);
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[j] - arr[i] <= 1) {
                    cnt++;
                }
            }
            if (cnt > max)
                max = cnt;
            cnt = 0;
        }
        return max;
    }

    public static int pickingNumbers(int[] a) {
        Arrays.sort(a);
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[j] - a[i] <= 1) {
                    cnt++;
                }
            }

            if (cnt > max) {
                max = cnt;
            }

            cnt = 0;
        }
        return max;
    }
}
