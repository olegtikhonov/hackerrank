package test.twest.test.twest.hackerrank;


import java.math.BigInteger;

/**
 * Sherlock and Squares
 */
public class SherlockAndSquares {
    public static int squares(int a, int b) {
        int result = 0;
        BigInteger bSquare = BigInteger.valueOf(b);
        BigInteger bigSq = bSquare.pow(b);
        if(a > 1) {
            for(int i = 2; i <= bigSq.signum(); i++) {
                BigInteger iSquare = BigInteger.valueOf(i * i);
                if(  iSquare.signum() >= a && iSquare.signum() <= b) {
                    ++result;
                }
            }
        }

        return result;
    }

    public static int test(int a, int b) {
        int count = (int) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a))) + 1;
        return count;
    }
}
