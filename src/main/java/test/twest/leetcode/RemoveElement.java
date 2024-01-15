package test.twest.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * Example 1:
 *
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 *
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int[] counter = new int[51]; // numbers from 0 - 50

        Arrays.fill(counter, -1);

        int k = 0;
        for(int inx = 0; inx < nums.length; inx++) {
            if(nums[inx] != val) {
                if(counter[nums[inx]] == -1) {
                    counter[nums[inx]] = 0;
                }
                counter[nums[inx]]++;// increase a number
            }
        }

        for(int indx = 0; indx < counter.length; indx++) {
            if(counter[indx] != -1) {
                k += counter[indx];
            }
        }
        return k;
    }

    public int removeElementInPlace(int[] nums, int val) {
        int k = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != val) {
                nums[k] = nums[j];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] first = {3,2,2,3};
        int val = 3;
        int result = removeElement.removeElement(first, val);
        System.out.println(result);

        int[] second = {0,1,2,2,3,0,4,2};
        val = 2;
        result = removeElement.removeElement(second, val);
        System.out.println(result);

        result = removeElement.removeElementInPlace(second, val);
        System.out.println("In place:= " + result);
    }
}
