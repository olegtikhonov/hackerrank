package test.twest.test.twest.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * A modified Kaprekar number is a positive whole number with a special property. If you square it, then split the number
 * into two integers and sum those integers, you have the same value you started with.
 */
public class KaprekarNumbers {

    private static boolean isKaprekar(int num) {
        long squared = (long) num * num;
        String str = String.valueOf(squared);
        String left = str.substring(0, str.length() / 2);
        String right = str.substring(str.length() / 2);
        int numL = (left.isEmpty()) ? 0 : Integer.parseInt(left);
        int numR = (right.isEmpty()) ? 0 : Integer.parseInt(right);
        if (numL + numR == num) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] kaprekarNumbers(int p, int q) {
        List<Integer> kaprekarNumbers = new ArrayList<>();

        for(int inx = p; inx <= q; inx++) {
            if(isKaprekar(inx)) {
                kaprekarNumbers.add(inx);
            }
        }
        int[] result = new int[kaprekarNumbers.size()];

        if(result.length == 0) {
            System.out.println("INVALID RANGE");
            return new int[0];
        }

        // no conversion
        for(int inx = 0; inx < result.length; inx++) {
            result[inx] = kaprekarNumbers.get(inx);
        }

        return result;
    }
}
