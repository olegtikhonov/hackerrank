package test.twest.leetcode;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: 1
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        //trick is to use XOR

        for (int inx = 0; inx < nums.length; inx++) {
            result ^= nums[inx];
        }
        return result;
    }

    /**
     * once=(once^num) & (~twice)
     * twice=(twice^num) & (~once)
     */
    public int singleNumberTwo(int[] nums) {
        int once = 0, twice = 0;
        for (int inx = 0; inx < nums.length; inx++) {
            // another trick
            once = (once ^ nums[inx]) & (~twice);
            twice = (twice ^ nums[inx]) & (~once);
        }
        return once;
    }

    public static void main(String[] args) {
        SingleNumber runner = new SingleNumber();
        int[] first = new int[]{2, 2, 1};
        int result = runner.singleNumber(first);
        System.out.println("Result:=" + result);

        int[] second = new int[]{4, 1, 2, 1, 2};
        result = runner.singleNumber(second);
        System.out.println("Result:=" + result);

        //0,1,0,1,0,1,99
        int[] third = new int[]{0, 1, 0, 1, 0, 1, 99};
        result = runner.singleNumberTwo(third);
        System.out.println("Result:=" + result);
    }
}
