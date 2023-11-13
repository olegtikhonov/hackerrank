package test.twest.algorithms;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class BubbleSortTest {

    @Test
    public void bubble() {
        int[] toSort = {1, 3, 8, 2, 9, 2, 5, 6};
        System.out.println(Arrays.toString(toSort));
        System.out.println(Arrays.toString(BubbleSort.bubble(toSort)));
    }
}