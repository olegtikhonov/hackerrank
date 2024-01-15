package test.twest.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class EasyRemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // Set visited remove duplicates
        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            visited.add(num);
        }
        // orders the elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer el: visited) {
            pq.offer(el);
        }

        int inx = 0;
        // copy visited elements from the first index in the array
        while(!pq.isEmpty()) {
            nums[inx++] = pq.poll();
        }

        return visited.size();
    }

    public static void main(String[] args) {
        EasyRemoveDuplicatesFromSortedArray easyRemoveDuplicatesFromSortedArray = new EasyRemoveDuplicatesFromSortedArray();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int result = easyRemoveDuplicatesFromSortedArray.removeDuplicates(nums);
        System.out.println(result);
    }
}
