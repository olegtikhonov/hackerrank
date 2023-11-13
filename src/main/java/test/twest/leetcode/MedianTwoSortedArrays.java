package test.twest.leetcode;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * The idea is to use Binary Search on two arrays. However, it is complicated,
 * to manage indexes and sub-arrays.
 * The idea use a min heap instead.
 */
public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // case 1 - middle is odd, size / 2, pop and show by top
        // case 2 - middle is even,
        PriorityQueue<Integer> resHolder = new PriorityQueue<>();
        IntStream.of(nums1).forEach(resHolder::add);
        IntStream.of(nums2).forEach(resHolder::add);

        int totalSumOfLens = nums1.length + nums2.length;
        double count = -1;
        double mid1 = -1, mid2;
        while (!resHolder.isEmpty()) { // Here is a trick, we exit when come to the middle of heap O(N/2)
            count++;
            // odd case
            if (totalSumOfLens % 2 != 0 && count == totalSumOfLens / 2) {
                return (double) resHolder.peek();
            }
            // even case, one before middle of array
            if (totalSumOfLens % 2 == 0 && count == (totalSumOfLens / 2) - 1) {
                mid1 = resHolder.peek();
            }
            // even case, one after middle of array
            if (totalSumOfLens % 2 == 0 && count == totalSumOfLens / 2) {
                mid2 = resHolder.peek();
                return (mid1 + mid2) / 2;
            }
            resHolder.poll();
        }
        return Double.NEGATIVE_INFINITY;
    }

    public static void main(String[] args) {
        MedianTwoSortedArrays medianTwoSortedArrays = new MedianTwoSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double res = medianTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println("The median of two arrays is " + res);
    }
}
