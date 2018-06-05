package test.twest.test.twest.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * John Watson knows of an operation called a right circular rotation on an array of integers. One rotation operation moves
 * the last array element to the first position and shifts all remaining elements right one. To test Sherlock's abilities,
 * Watson provides Sherlock with an array of integers. Sherlock is to perform the rotation operation a number of times
 * then determine the value of the element at a given position.
 *
 * For each array, perform a number of right circular rotations and return the value of the element at a given index.
 */
public class CircularArrayRotation {

    /**
     *
     * @param a an array to be rotated
     * @param k a number of rotations
     * @param m a range from where to return values
     *
     * @return
     */
    public static int[] circularArrayRotation(int[] a, int k, int[] m) {
        int rotationPos = k % a.length;
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            numbers.add(a[i]);
        }

        List<Integer> part1 = numbers.subList(0, numbers.size() - rotationPos);
        List<Integer> part2 = numbers.subList(numbers.size() - rotationPos, numbers.size());
        List<Integer> finalList = new ArrayList<>(part2);
        finalList.addAll(part1);

        int[] result = new int[m.length];
        for(int i = 0; i < m.length; i++) {
            result[i] = finalList.get(m[i]);
        }



//        for(int i = 0; i < k; i++) {
//            for(int j = (a.length - 2); j >= 0; j--) {
//                // swap [j]  and a[j+1]
//                a[j] = a[j] ^ a[j + 1];
//                a[j + 1] = a[j] ^ a[j + 1];
//                a[j] = a[j] ^ a[j + 1];
//            }
//        }
//
//        int[] result = new int[m.length];
//        for(int i = 0; i < result.length; i++) {
//            result[i] = a[m[i]];
//        }
//
        return result;
    }
}
