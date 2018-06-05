package test.twest.test.twest.hackerrank;


/**
 * You wish to buy video games from the famous online video game store Mist. Usually, all games are sold at the same price,
 * dollars. However, they are planning to have the seasonal Halloween Sale next month in which you can buy games at a cheaper
 * price. Specifically, the first game you buy during the sale will be sold at dollars, but every subsequent game you buy will
 * be sold at exactly dollars less than the cost of the previous one you bought. This will continue until the cost becomes
 * less than or equal to dollars, after which every game you buy will cost dollars each.
 */
public class HalloweenSale {

    /**
     *
     * @param price
     * @param step
     * @return
     */
    private static int calculateNewPrice(int price, int step, int m) {
        int current = price - step;
        return (current >= m) ? current : m;
    }

    /**
     *
     * @param p a price
     * @param d dollars less
     * @param m less or equals. minimum
     * @param s a budget
     * @return
     */
    public static int howManyGames(int p, int d, int m, int s) {
        if(p > s) {
            return 0;
        }
        int sum = p, counter = 1;
        int currentPrice = p;

        while (sum <= s) {
            currentPrice = calculateNewPrice(currentPrice, d, m);
            sum += currentPrice;
            if(sum <= s) {
                counter++;
            }
        }
        return counter;
    }
}
