package test.twest.test.twest.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumToys {

    public static int maximumToys(int[] prices, int k) {
        int count = 0;
        long localMaximum = 0l;
        // int[] to List
        List<Integer> toSort = new ArrayList<>();
        for(int i : prices) {
            toSort.add(i);
        }
        // sorts
        Collections.sort(toSort);
        // Finds the maximum
        for(Integer item : toSort) {
            localMaximum += item;
            if(localMaximum <= k) {
                count++;
            }
        }
        return count;
    }
}
