package test.twest.test.twest.geeks4geeks;

import org.junit.jupiter.api.Test;

public class MaxSubbArrayProblemTest {

    @Test
    public void calculateSubArraySum() {
        int[] input = {-1, 2, 4, -3, 5, 2, -5, 2};
        System.out.println(MaxSubbArrayProblem.calculateSubArraySum(input));
        int[] case2 = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(MaxSubbArrayProblem.calculateSubArraySum(case2));
    }
}