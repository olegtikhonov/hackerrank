package test.twest.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Approach:
 * 1. three nested loops
 * 2. hashmap + two nested loops
 * 3. two pointers + sort an array
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Step 1: sort the orig array
        Arrays.sort(nums);

        // Step 2: Iterate over the input array to fix the value of ‘a’. a+b+c=0, a = -(b+c)


        int curIndx = 0;

        // take slices of three elements
        while((curIndx + 3) < nums.length ) {
            // slice
            int[] tmp = Arrays.copyOfRange(nums, curIndx, curIndx + 3);
            if(isOurGuy(tmp)) {
                List<Integer> list = new ArrayList<Integer>();
                Collections.addAll(list, Arrays.stream(tmp).boxed().toArray(Integer[]::new));
                result.add(list);
            }
            curIndx++;
        }
        
        return  result;
    }

    boolean isOurGuy(int[] toCheck) {
        // constraints
        //[nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0
        if((toCheck[0] != toCheck[1]) && (toCheck[0] != toCheck[2]) && (toCheck[1] != toCheck[2])) {
            return (toCheck[0] + toCheck[1] + toCheck[0]) == 0;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] first = {-1, 0, 1, 2, -1, -4};
        ThreeSum t3Sum = new ThreeSum();
        List<List<Integer>> res = t3Sum.threeSum(first);
        System.out.println(res);
    }
}
