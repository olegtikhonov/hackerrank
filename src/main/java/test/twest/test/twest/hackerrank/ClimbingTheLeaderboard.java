package test.twest.test.twest.hackerrank;

import java.util.*;

public class ClimbingTheLeaderboard {

    static int[] buildRanks(int[] scores) {
        int[] ranks = new int[scores.length];
        int rank = 1;
        for (int i = 0; i < ranks.length; i++) {
            if (i > 0 && scores[i] != scores[i - 1]) {
                rank++;
            }
            ranks[i] = rank;
        }
        return ranks;
    }

    // binary search
    static int solve(int[] scores, int[] ranks, int alice) {
        int lower = 0;
        int upper = scores.length - 1;
        int aliceRank = 1;
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            if (alice == scores[middle]) {
                aliceRank = ranks[middle];
                break;
            } else if (alice < scores[middle]) {
                aliceRank = ranks[middle] + 1;
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }
        return aliceRank;
    }

    public static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] ranks = buildRanks(scores);
        List<Integer> tmp = new ArrayList<>();
        for(int grade : alice) {
            tmp.add(solve(scores, ranks, grade));
        }
        // O(N)
        int[] result = new int[tmp.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = tmp.get(i);
        }

        return result;
    }
}
