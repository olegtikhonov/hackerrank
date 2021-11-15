package test.twest.algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SelectionSortTest {

    @Test
    public void selectionSort() {
        int[] toBeSorted = {2, 4, 6, 1, 8, 10, 7};
        Arrays.stream(toBeSorted).forEach(i -> System.out.print(i + " "));
        SelectionSort.selectionSort(toBeSorted);
        System.out.println();
        Arrays.stream(toBeSorted).forEach(i -> System.out.print(i + " "));
    }
}