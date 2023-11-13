package test.twest.algorithms;

import org.junit.jupiter.api.Test;

public class EuclidGCDTest {
    @Test
    public void gcd() {
        int a = 90;
        int b = 30;
        int result = EuclidGCD.gcd(a, b);
        System.out.println(result);
    }
}