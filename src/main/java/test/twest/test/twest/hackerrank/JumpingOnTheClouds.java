package test.twest.test.twest.hackerrank;

public class JumpingOnTheClouds {

    public static int jumpingOnClouds(int[] c) {
        int count = 0;
        int i = 0;
        while (i < c.length - 1) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                i = i + 2;
                count++;
            } else {
                i++;
                count++;
            }
        }
        return count;
    }
}
