package test.twest.recursion;

public class PrintAllPermutations {

    public static void permutation(char[] array, int fixedIndex) {
        if(fixedIndex == array.length - 1) {
            System.out.println(array);
            return;
        }

        for(int indx = 0; indx < array.length; indx++) {
            swap(array, indx, fixedIndex);
            permutation(array, fixedIndex + 1);
            // clear
            swap(array, indx, fixedIndex);
        }
    }


    static void swap(char[] array, int indx, int fixedIndex) {
        char tmp = array[indx];
        array[indx] = array[fixedIndex];
        array[fixedIndex] = tmp;
    }

    public static void main(String[] args) {
        char[] input = {'a', 'b', 'c'};
        PrintAllPermutations.permutation(input, 0);
    }
}
