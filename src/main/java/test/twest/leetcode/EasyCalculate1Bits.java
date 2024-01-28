package test.twest.leetcode;

/**
 * Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 * Note:
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * <p>
 * Example 3:
 * <p>
 * Input: n = 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 */
public class EasyCalculate1Bits {
    public int hammingWeight(int n) {
        int res = 0;
        while(n > 0) {
            res += n % 2; //the same as & mask 1
            n = n >> 1;   // shift right
        }
        return res;
    }

    public static void main(String[] args) {
        EasyCalculate1Bits runner = new EasyCalculate1Bits();
        int n = 5; // 1 0 1
        System.out.println("Result:=" + runner.hammingWeight(n));
    }
}
