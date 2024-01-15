package test.twest.test.twest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * array[] = {1, 2, 3}
 *
 * 3, 2, 1 = 6
 *
 * We take one element as fixed element and then print the rest of the elements
 *
 * The idea is to use backtracking
 *
 * we should generateAll(int[] array, int index, List<int[]> permutations)
 *
 * base case:
 * if(index == array.length) {
 *     permute.add(Arrays.copyOf(arr, arr.length));
 *     return;
 * }
 *
 * iterate over entire array
 * for(int i = index; i < array.length; index++) {
 *     // swap
 *     int tmp = array[i];
 *     array[i] = array[index];
 *     array[index] = tmp;
 *
 *     generate(array, index +1, permutations)
 *
 *     // swap again
 *     int tmp = array[i];
 *  *  array[i] = array[index];
 *  *  array[index] = tmp;
 *
 * }
 *
 *
 *
 */
public class PrintAllPermutationInArray {
    public void generatePermutations(int[] array, int index, List<int[]> permutations) {
        if(index == array.length) {
            permutations.add(Arrays.copyOf(array, array.length));
            return;
        }

        for(int i = index; i < array.length; i++) {
            // swap. i.e. make a new permutation
            int tmp = array[i];
            array[i] = array[index];
            array[index] = tmp;

            // call the functions
            generatePermutations(array, index + 1, permutations);

            // swap again, back to the previous position
            tmp = array[i];
            array[i] = array[index];
            array[index] = tmp;
        }
    }

    public static void main(String[] args) {
        PrintAllPermutationInArray printAllPermutationInArray = new PrintAllPermutationInArray();
        int[] array = {1, 2, 3};
        List<int[]> permutations = new ArrayList<>();
        printAllPermutationInArray.generatePermutations(array, 0, permutations);
        permutations.forEach(System.out::println);
    }
}
