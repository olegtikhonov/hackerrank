package test.twest.test.twest.hackerrank;

/**
 * You are the benevolent ruler of Rankhacker Castle, and today you're distributing bread.  Your subjects are in a line,
 * and some of them already have some loaves.
 * Times are hard and your castle's food stocks are dwindling, so you must distribute as few loaves as possible according to the following rules:
 * Every time you give a loaf of bread to some person i you must also give a loaf of bread to the person immediately in
 * front of or behind them in the line (i.e., persons i + 1 or i - 1)
 * After all the bread is distributed, each person must have an even number of loaves.
 * Given the number of loaves already held by each citizen, find and print the minimum number of loaves you must
 * distribute to satisfy the two rules above. If this is not possible, print NO.
 *
 * Node: in the online editor have to change return type from int to String and inside the code wrap return values:
 * String.valueOf(...)
 */
public class FairRations {
    public static int fairRations(int[] B) {
        int sum = 0, count = 0;

        for (int i = 0; i < B.length; i++) {
            sum += B[i];
        }

        if (sum % 2 == 1) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < B.length; i++) {
                if (B[i] % 2 != 0) {
                    B[i] = B[i] + 1;
                    B[i + 1] = B[i + 1] + 1;
                    count += 2;
                }
            }
        }
        return count;
    }
}
