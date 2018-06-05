package test.twest.test.twest.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ServiceLane {

    private static int findMin(int[] width, int left, int right) {
        int min = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++) {
            min = Math.min(min, width[i]);
        }
        return min;
    }

    public static int[] serviceLane(int[] width, int[][] cases) {
        List<Integer> tmp = new ArrayList<>();

        for(int inx = 0; inx < cases.length; inx++) {
            tmp.add(findMin(width, cases[inx][0], cases[inx][1]));
        }

        int[] result = new int[tmp.size()];
        for (int inx = 0; inx < result.length; inx++) {
            result[inx] = tmp.get(inx);
        }

        return result;
    }
}
