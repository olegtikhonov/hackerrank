package test.twest.leetcode;

/**
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 *
 *
 * Example 1:
 *
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 *
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 *
 *
 * Possible solution:
 * We maintains two arrays: int[] left, int[] right
 * initially our arrays initiated by 1.
 * First iteration, we comparing our left side, if greater that current index, we add current + neighboor.
 * Second iteration, we comparing our right side, if ...
 * Third, we are going to Math.max(left, right) than total += ...
 */
public class Candy {
    public int candy(int[] ratings) {
        int[] left = initArray(ratings.length);
        int[] right = initArray(ratings.length);

        // left[inx]
        for(int inx = 0; inx < ratings.length; inx++) {
            if((inx + 1) < (ratings.length -1)) {
                if(ratings[inx] > ratings[inx + 1]) {
                    left[inx] = left[inx] + left[inx + 1];
                }
            }
        }
        printArray(left);

        // right[inx]
        for(int inx = right.length - 1; inx >= 0; inx --) {
            if((inx - 1) >= 0) {
                if(ratings[inx] > ratings[ inx - 1]) {
                    right[inx] = right[inx] + right[inx - 1];
                }
            }
        }
        printArray(right);

        return sumMax(left, right);
    }

    int[] initArray(int size) {
        int[] newArray = new int[size];
        for(int inx = 0; inx < size; inx++) {
            newArray[inx] = 1;
        }
        return newArray;
    }

    int sumMax(int[] left, int[] right) {
        int total = 0;
        for(int inx = 0; inx < right.length; inx++) {
            total += Math.max(left[inx], right[inx]);
        }
        return total;
    }

    void printArray(int[] array) {
        int size = array.length;
        while (size-- != 0) {
            System.out.print(" " + array[size]);
        }
        System.out.println();
    }
}
