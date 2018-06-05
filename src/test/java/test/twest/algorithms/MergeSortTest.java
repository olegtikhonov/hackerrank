package test.twest.algorithms;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void mergeSort() {
        int[] toSort = {1, 3, 8, 2, 9, 2, 5, 6};
        // before
        System.out.println(Arrays.toString(toSort));
        MergeSort.mergeSort(toSort);
        // after
        System.out.println(Arrays.toString(toSort));
    }
}