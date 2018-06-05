package test.twest.test.twest.hackerrank;

public class PermutationEquation {

    public static int getIndex(int[] array, int value) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == value) {
                return i + 1;
            }
        }
        return -1;
    }

    public static int[] permutationEquation(int[] p) {
        int tmp = 0;
        int[] result = new int[p.length];

        for(int i = 0; i < p.length; i++) {
            tmp = getIndex(p, i + 1);
            result[i] = getIndex(p, tmp);
        }
        return result;
    }
}
