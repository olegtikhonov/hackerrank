package test.twest.test.twest.hackerrank;


/**
 * https://www.hackerrank.com/challenges/absolute-permutation/problem
 */
public class AbsolutePermutation {

    public static int[] absolutePermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            if (arr[i - 1] == 0) {
                if (i + k <= n) {
                    arr[i - 1] = i + k;
                    arr[i + k - 1] = i;
                } else
                    return new int[]{-1};
            }
        }
        return arr;
    }
}
