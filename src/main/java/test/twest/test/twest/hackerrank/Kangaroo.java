package test.twest.test.twest.hackerrank;

/**
 * You are choreograhing a circus show with various animals. For one act, you are given two kangaroos on a number line
 * ready to jump in the positive direction (i.e, toward positive infinity).
 * The first kangaroo starts at location and moves at a rate of meters per jump.
 * The second kangaroo starts at location and moves at a rate of meters per jump.
 * You have to figure out a way to get both kangaroos at the same location as part of the show.
 * Complete the function kangaroo which takes starting location and speed of both kangaroos as input, and return or appropriately.
 * Can you determine if the kangaroos will ever land at the same location at the same time? The two kangaroos must land at
 * the same location after making the same number of jumps.
 */
public class Kangaroo {
    public static String kangaroo(int x1, int v1, int x2, int v2) {
//        for(int first = x1, second = x2; (first < 10000) && (second < 10000); first+=v1, second+= v2) {
//            if(first == second) {
//                return "YES";
//            }
//        }
//        return "NO";
        if (v1 < v2) return "NO";
        if (x1 < x2 && v1 > v2) {
            int xDiff = Math.abs(x1 - x2);
            int vDiff = Math.abs(v1 - v2);
            if (xDiff % vDiff == 0) {
                return "YES";
            } else {
                return "NO";
            }
        }
        return "NO";
    }

}
