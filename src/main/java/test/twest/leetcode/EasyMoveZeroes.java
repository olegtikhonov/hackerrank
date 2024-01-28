package test.twest.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 */
public class EasyMoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 1;
        for(int inx = 0; inx < nums.length; inx++) {
            if(right < nums.length) {
                if(nums[left] == 0 && nums[right] != 0) {
                    nums[left] = nums[right];
                    nums[right] = 0;
                    ++left;
                    ++right;
                } else if (nums[left] == 0 && nums[right] == 0) {
                    ++right;
                }
            }
        }

        IntStream.of(nums).forEach(item -> System.out.print(" " + item));
    }

    public static void main(String[] args) {
        EasyMoveZeroes runner = new EasyMoveZeroes();
        int[] input = new int[] {0,1,0,3,12};
        runner.moveZeroes(input);

        String s = "dog cat cat dog";
        String[] in = s.split(" ");
        Arrays.stream(in).forEach(sr -> System.out.print(" --> " + sr));
    }
}
