package test.twest.test.twest.hackerrank;

/**
 * Using + ||/$$ - operation, answer the quesiton, is it possible to get a target
 *
 * For example:
 * nums = {9, 3, 7} target is 13
 * Answer is True, 9 - 3  + 7 = 13
 *
 */
public class BackTrackingPossibleSumMinus {

    boolean calc(int[] array, int target, int currentSum, int curIndx) {
        // if we are at the end of the array
        System.out.println("Current index " + curIndx);
        if(curIndx == (array.length)) {
            return target == currentSum;
        }

        return calc(array, target, currentSum + array[curIndx], curIndx + 1 ) ||
                calc(array, target, currentSum - array[curIndx], curIndx + 1 );
    }

    boolean solve(int[] array, int target) {
        // edge cases
        if(array.length <= 0) {
            return false;
        }

        return calc(array, target, array[0], 1);
    }

    public static void main(String[] args) {
        int[] array = {9, 3, 7};
        int target = 13;
        BackTrackingPossibleSumMinus backTrackingPossibleSumMinus = new BackTrackingPossibleSumMinus();
        boolean result = backTrackingPossibleSumMinus.solve(array, target);
        System.out.println(result);
    }
}
