package test.twest.test.twest.hackerrank;


/**
 * Little Bobby loves chocolate. He frequently goes to his favorite store, Penny Auntie, to buy them. They are having a
 * promotion at Penny Auntie. If Bobby saves enough wrappers, he can turn them in for a free chocolate.
 * Complete the chocolateFeast function in the code stub below to return the number of chocolates Bobby can eat with a
 * given amount of money after taking full advantage of the promotion.
 * Note: Little Bobby will always turn in his wrappers if he has enough to get a free chocolate.
 */
public class ChocolateFeast {
    /**
     *
     * @param n money to spend
     * @param c const of chocolate
     * @param m number of wrappers to change to the chocolate
     *
     * @return
     */
    public static int chocolateFeast(int n, int c, int m) {
        int numberOfBroughtChocolates = n / c;
        int wrappers = numberOfBroughtChocolates;

        while(wrappers >= m) {
            numberOfBroughtChocolates += (wrappers / m);
            int leftover = wrappers % m;
            wrappers = (wrappers / m) + leftover;
        }

        return numberOfBroughtChocolates;
    }
}
