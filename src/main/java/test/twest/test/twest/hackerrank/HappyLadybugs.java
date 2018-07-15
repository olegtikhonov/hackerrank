package test.twest.test.twest.hackerrank;

/**
 * @see <a href="https://www.hackerrank.com/challenges/happy-ladybugs/problem">Happy Lady Bugs</a>
 */
public class HappyLadybugs {

    /**
     * The conditions of happiness in the world of lady bugs.
     * <br>
     *   .W.   <br>
     *  (o|o)  <br>
     *   `'`   <br>
     *  <br>
     * @param s as a bunch of bugs
     *
     * @return
     */
    private static boolean isHappy(String s) {
        if (hasUnique(s)) {
            return false;
        }

        if (alreadyHappy(s)) {
            return true;
        }

        if (hasSpace(s)) {
            return true;
        }

        return false;
    }

    /**
     * If in the sequence of lady bugs is one and only one, then it is unhappy.
     *
     * @param s as a bug
     * @return
     */
    private static boolean hasUnique(String s) {
        int[] ascii = new int[26];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '_') {
                ascii[(int) s.charAt(i) - 65]++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (ascii[i] == 1) {
                return true;
            }
        }

        return false;
    }

    /**
     * If more than two bugs of the same color are happy, else unhappy.
     *
     * @param s as a bug
     * @return
     */
    private static boolean alreadyHappy(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (i == 0 && s.charAt(i) != s.charAt(i + 1)) {
                return false;
            } else if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * In order to be able moving, has to be a space.
     *
     * @param s as a bug
     * @return
     */
    private static boolean hasSpace(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '_') {
                return true;
            }
        }

        return false;
    }

    public static String happyLadybugs(String b) {
        return isHappy(b) ? "YES" : "NO";
    }
}
