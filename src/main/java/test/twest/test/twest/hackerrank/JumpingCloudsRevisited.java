package test.twest.test.twest.hackerrank;

public class JumpingCloudsRevisited {
    private static final int ENERGY = 100;

    /**
     *
     * @param c - clouds
     * @param k - jump distance
     *
     * @return
     */
    public static int jumpingOnClouds(int[] c, int k) {
        int currentIndex;
        int currentEnergy = ENERGY;
        int numberClouds = c.length;

        for(int i = 0; i < numberClouds; i+= k) {
            currentIndex = (i + k) % numberClouds;

            if(c[currentIndex] == 0) {
                currentEnergy -= 1;
            } else {
                currentEnergy -= 3;
            }
        }
        return currentEnergy;
    }
}
