package test.twest.test.twest.hackerrank;


import java.util.*;

/**
 * Complexity time:
 * n + n + n*Log*n + n = 3n + n*Log*n = n*Log*n
 *
 */
public class EqualizeArray {

    public static int equalizeArray(int[] arr) {
        int minimalCount = 0, local = 0;

        Map<Integer, Integer> frequency = new HashMap<>();
        // Counts a frequency of all elements
        for(int i = 0; i < arr.length; i++) {
            local = arr[i];
            if(!frequency.containsKey(local)) {
                frequency.put(local, 1);
            } else {
                frequency.put(local, frequency.get(local) + 1);
            }
        }

        if(frequency.size() == arr.length) {
            return (arr.length - 1);
        }

        List<Integer> tmp = new ArrayList<>();
        // Creates a list of frequent elements
        for(Integer key : frequency.keySet()) {
            tmp.add(frequency.get(key));
        }
        // Sorts them
        Collections.sort(tmp);
        Integer[] array = tmp.toArray(new Integer[tmp.size()]);

        int localMaximum = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++) {
            if(localMaximum < array[array.length - 1]) {
                localMaximum = array[array.length - 1];
            }
            // until first meeting with maximum
            if(array[i] != localMaximum) {
                minimalCount += array[i];
            }else {
                minimalCount += ((array.length - (i + 1)) * localMaximum);
                return minimalCount;
            }
        }

        return minimalCount;
    }
}
