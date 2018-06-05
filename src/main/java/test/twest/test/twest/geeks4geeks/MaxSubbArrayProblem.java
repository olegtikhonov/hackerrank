package test.twest.test.twest.geeks4geeks;

import static java.lang.Math.max;


public class MaxSubbArrayProblem {

    public static int calculateSubArraySum(int[] array) {
        int best = 0, sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum = max(array[i], sum + array[i]);
            best = max(best, sum);
        }
        return best;
    }
}
