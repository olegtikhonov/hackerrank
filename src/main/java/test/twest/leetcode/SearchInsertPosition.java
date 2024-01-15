package test.twest.leetcode;

/**
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // binary search
        // a question what to do when number is not found
        // use cases
        if(nums[0] > target) {
            return 0;
        }
        if(nums[nums.length - 1] < target) {
            return nums.length;
        }

        int left = 0, right = nums.length - 1, mid = 0;

        while(left <= right) {
            mid = (left + right) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // here is a trick to return left
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int result = searchInsertPosition.searchInsert(nums, target);
        System.out.println(result);
    }
}
