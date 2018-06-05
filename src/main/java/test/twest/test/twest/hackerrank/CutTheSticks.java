package test.twest.test.twest.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CutTheSticks {

    public static int findMinimum(int[] arr) {
        int localMinimum = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0 && (arr[i] < localMinimum)) {
                localMinimum = arr[i];
            }
        }

        return localMinimum;
    }

    public static int[] cutTheSticks(int[] arr) {
        // Complete this function
        int countOfChanges = 0;
        List<Integer> output = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            int localMin = findMinimum(arr);
            int localSum = 0;
            if(localMin < Integer.MAX_VALUE) {
                for(int j = 0; j < arr.length; j++) {
                    if(arr[j] > 0) {
                        arr[j] = arr[j] - localMin;
                        localSum++;
                    }
                }
                output.add(localSum);
                System.out.println(localSum);
            }

        }
        int[] r = new int[output.size()];
        for(int i = 0; i < output.size(); i++) {
            r[i] = output.get(i);
        }
        return r;
    }
}
