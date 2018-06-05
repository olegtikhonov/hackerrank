package test.twest.test.twest.hackerrank;

import java.math.BigInteger;

public class ExtraLongFactorials {

//    private static long factorial(long number) {
//        if(number < 3) {
//            return  number;
//        } else {
//            return (number * factorial(number -1));
//        }
//    }

    public static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;

        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return result;
    }

    public static void extraLongFactorials(int n) {
        System.out.println(factorial(BigInteger.valueOf(n)));
    }
}
