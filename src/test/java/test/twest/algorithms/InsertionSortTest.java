package test.twest.algorithms;

import java.util.Arrays;
import org.junit.jupiter.api.Test;


public class InsertionSortTest {

    @Test
    public void insertionSort() {
        int[] toBeSorted = {2, 4, 6, 1, 8, 10, 7};
        Arrays.stream(toBeSorted).forEach(i -> System.out.print(i + " "));
        InsertionSort.insertionSort(toBeSorted);
        System.out.println();
        Arrays.stream(toBeSorted).forEach(i -> System.out.print(i + " "));
    }
}