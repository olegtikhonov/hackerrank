package test.twest.test.twest.hackerrank;


public class SavePrisoner {
    /**
     *
     * @param n number of prisoners
     * @param m number of sweets
     * @param s the chair number to start passing out treats at
     * @return
     */
    public static int saveThePrisoner(int n, int m, int s){
        int a = s + m - 1;
        if (a > n) {
            if (a % n == 0) {
                return n;
            }
            return a % n;
        }

        return a;
    }
}
