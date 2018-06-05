package test.twest.test.twest.hackerrank;

public class UtopianTree {
    public static int utopianTree(int n) {
        int currentHeight = 1;

        for(int i = 1; i <= n; i++) {
            if((i % 2) == 0) {
                currentHeight += 1;
            } else {
                currentHeight *= 2;
            }
        }

        return currentHeight;
    }
}
