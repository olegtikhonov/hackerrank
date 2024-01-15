package test.twest.leetcode;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
 * water (blue section) the container can contain is 49.
 * <p>
 * Solution:
 * Use two pointers, left and right. Move this which has lower value.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0, numOfIntervals = height.length - 1;
        int tmp = 0;
        // How do we calculate area
        // S = Math.abs(left - right) * numberOfIntervals;
        // max = Math.max(max, S)
        while ((left <= right) || numOfIntervals > 0) {
            tmp = Math.min(height[left], height[right]) * numOfIntervals;
            max = Math.max(tmp, max);

            if (height[left] <= height[right])
                left++;
            else
                right--;
            numOfIntervals--;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int result = containerWithMostWater.maxArea(height);
        System.out.println(result);

        int[] height2 = {1, 1};
        containerWithMostWater = new ContainerWithMostWater();
        result = containerWithMostWater.maxArea(height2);
        System.out.println(result);
    }
}
