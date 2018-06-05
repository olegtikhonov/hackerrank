package test.twest.test.twest.hackerrank;

public class BreakingRecords {

    public static int[] breakingRecords(int[] score) {
        int[] results = new int[2];
        int min  = score[0], minCount = 0;
        int max = score[0], maxCount = 0;
        // 0 - for minimum
        // 1 - for maximum

        for (int i = 1; i < score.length; i ++) {
            // checks min
            if(min < score[i]) {
                min = score[i];
                ++minCount;
            }
            // checks max
            if(max > score[i]) {
                max = score[i];
                ++maxCount;
            }
        }

        results[0] = minCount;
        results[1] = maxCount;

        return results;
    }
}
