package test.twest.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class EuclidGCDTest {
    @Test
    public void gcd() {
        int a = 90;
        int b = 30;
        int result = EuclidGCD.gcd(a, b);
        System.out.println(result);
    }
}