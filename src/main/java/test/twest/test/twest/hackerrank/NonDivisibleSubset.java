package test.twest.test.twest.hackerrank;


/**
 * Given a set of distinct integers, print the size of a maximal subset of where the sum of any numbers in is not evenly divisible by .
 *
 * Input Format
 *
 * The first line contains space-separated integers, and , the number of values in and the non factor.
 * The second line contains space-separated integers describing , the unique values of the set.
 */
public class NonDivisibleSubset {
    public static int nonDivisibleSubset(int k, int[] S) {
        // the trick taken from the forum
        // said (A + B) / k iff (A % k) + (B % k) = k
        int[] modulusBuckets = new int[k];
        int nonDivisibleSubsetCardinality = 0;

        for (int i = 0; i < S.length; i++) {
            int bucket = S[i] % k;
            modulusBuckets[bucket] += 1;
        }

        nonDivisibleSubsetCardinality += (modulusBuckets[0] >= 1) ? 1 : 0;
        nonDivisibleSubsetCardinality += (k % 2 == 0 && modulusBuckets[k / 2] >= 1) ? 1 : 0;

        //Determine the max buckets we can use
        int maxBuckets = 0;
        if (k % 2 == 0) {
            maxBuckets = (k / 2) - 1;
        } else {
            maxBuckets = k / 2;
        }

        //Picks the biggest bucket of each pair for each even sum group
        for (int i = 1; i <= maxBuckets; i++) {
            nonDivisibleSubsetCardinality += Math.max(modulusBuckets[i], modulusBuckets[k - i]);
        }

        return nonDivisibleSubsetCardinality;
    }
}
