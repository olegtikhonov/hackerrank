package test.twest;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * This class solves the following problem:
 * Given N bins and K ball. You have to print all permutations, such as
 * for instance:
 * 2 - bins, 3 balls. Output looks:
 * 3  0
 * 2  1
 * 1  2
 * 0  3
 */
public class BinsBalls {
    private static Queue<String> baskets = new ArrayDeque<>();


    /**
     * Generates a list of all possible permutations.
     *
     * @param numOfBalls how many balls are
     * @param numOfBins  how many baskets are
     */
    public static void listAllPermutations(int numOfBalls, int numOfBins) {
        int[] set = new int[numOfBalls + 1];
        // Inits the array [0 ... #_of_balls] included
        for(int i = 0; i <= numOfBalls; i++) {
            set[i] = i;
        }
        // We need one more element because of 0 and last element included.
        putInBasket(set, "", numOfBalls + 1, numOfBins);
        baskets = filter(numOfBalls, baskets);
        // To see results in console
        System.out.println(baskets);
    }

    /**
     * Guys Nir solution.
     *
     * @param arr
     * @param totalBuckets
     * @param currBalls
     * @param currBucket
     */
    public static void doPermutations(int[] arr, int totalBuckets, int currBalls, int currBucket) {
        int cnt;
        // If last then print it all
        if (currBucket == 0) {
            arr[currBucket] = currBalls;

            for (cnt = 0; cnt < totalBuckets; cnt++) {
                System.out.print(arr[cnt]);
            }

            System.out.print("\n");

            return;
        }
        // Put different number of balls each time
        for (cnt = 0; cnt <= currBalls; cnt++) {
            arr[currBucket] = cnt;
            doPermutations(arr, totalBuckets, currBalls - cnt, currBucket - 1);
        }
    }

    /**
     * Puts balls into basket.
     *
     * @param set of possible "balls"
     * @param prefix
     * @param n a number of balls
     * @param k a number of baskets
     */
    public static void putInBasket(int set[], String prefix, int n, int k) {
        // Base case: k is 0, print prefix
        if (k == 0) {
            System.out.println(prefix);
            // Stores the permutation
            baskets.add(prefix);
            return;
        }
        // One by one add all characters from set and recursively call for k equals to k-1
        for (int i = 0; i < n; ++i) {
            // Next character of input added
            String newPrefix = prefix + set[i];
            // k is decreased, because we have added a new character
            putInBasket(set, newPrefix, n, k - 1);
        }
    }

    /**
     * Filters out the wrong result
     *
     * @param numOfBalls how many balls are
     * @param baskets a temporally result holder
     *
     * @return a new {@link Queue}
     */
    public static Queue<String> filter(int numOfBalls, Queue<String> baskets) {
        Queue<String> result = new ArrayDeque<>();
        int sum = 0;
        for (String basket: baskets) {
            sum = getSum(basket);

            if(sum == numOfBalls && basket.toCharArray().length == numOfBalls) {
                result.add(basket);
            }
        }
        return result;
    }

    /**
     * Calculates a sum from given string.
     *
     * @param numbersAsStr
     *
     * @return a summary
     */
    public static int getSum(String numbersAsStr) {
        char[] numbersAsChar = numbersAsStr.toCharArray();
        int sum = 0;

        for (char number: numbersAsChar) {
            sum += Integer.parseInt(String.valueOf(number));
        }
        return sum;
    }


    /**
     * A famious main function. Instead of unit test.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Case 1: when number of balls is greater then number of baskets
        BinsBalls.listAllPermutations(3, 2);
        // Case 2: when number of balls is less than number of baskets
        BinsBalls.listAllPermutations(3, 3);

        final int TEST_BUCKETS = 3;
        final int TEST_BALLS   = 3;
        int[] array = new int[TEST_BUCKETS];
        BinsBalls.doPermutations(array, TEST_BUCKETS, TEST_BALLS, TEST_BUCKETS -1);
    }
}
