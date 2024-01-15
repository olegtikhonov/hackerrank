package test.twest.leetcode;

/**
 * In this simple solution we do:
 * Convert int to array of characters
 * take care of two cases:
 * i.  positive
 * ii. negative
 */
public class ReverseInt {
    public int reverse(int x) {
        char[] intAsChar = String.valueOf(x).toCharArray();
        int till = 0;
        int index = intAsChar.length - 1;
        int sum = 0;

        if(intAsChar[0] == '-') {
            till = 1;
        }

        for(;index >= till; index--) {
            sum += (int) (Character.getNumericValue(intAsChar[index]) * Math.pow(10, index));
        }

        return (x >= 0) ? sum : (~(sum) + 1) /10;
    }


    public static void main(String[] args) {
        int first = -123;
        ReverseInt reverseInt = new ReverseInt();
        System.out.println(reverseInt.reverse(first));

        int second = 123;
        System.out.println(reverseInt.reverse(second));
    }
}
