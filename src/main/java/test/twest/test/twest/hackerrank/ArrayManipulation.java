package test.twest.test.twest.hackerrank;


public class ArrayManipulation {

    private static long[] updateValues(int lower, int upper, long[] array, int value) {
        if (upper == array.length) {
            array[lower - 1] += value;
        } else {
            array[lower - 1] += value;
            array[upper] -= value;
        }

        return array;
    }

    private static long findMax(long[] array) {
        long max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static long arrayManipulation(int n, int[][] queries) {
        // i and j indices. i goes through m lines
        // j goes through indices and value of
        long[] result = new long[n + 1];
        long max = 0, sum = 0;
        for(int line = 0; line < queries.length; line++) {
            result = updateValues(queries[line][0], queries[line][1], result, queries[line][2]);
        }

        for (int i = 0; i < n; i++) {
            sum += result[i];
            if (sum > max) {
                max = sum;
            }
        }

//        return findMax(result);
        return max;
    }
}
