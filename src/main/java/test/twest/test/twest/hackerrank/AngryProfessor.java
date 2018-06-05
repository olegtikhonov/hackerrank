package test.twest.test.twest.hackerrank;

public class AngryProfessor {

    public static String angryProfessor(int k, int[] a) {
        int cancellationCounter = 0;

        for(int i = 0; i < a.length; i++) {
            if(a[i] <= 0) {
                cancellationCounter++;
            }
        }

        return (cancellationCounter >= k) ? "NO" : "YES";
    }
}
