package test.twest.test.twest.fb;

/**
 * Input:
 * N = 5, S = 12
 * A[] = {1,2,3,7,5}
 * Output: 2 4
 * Explanation: The sum of elements
 * from 2nd position to 4th position
 * is 12.
 */
public class SubarrayWithGivenSum {
    public int[] indexOf(int[] arr, int key) {
        int[] result = {-1, -1};
        int left = 0, right = 1, sum = 0;
        boolean done = false;
        sum += arr[right] + arr[left];

        while((right < (arr.length -1)) && !done) {
            //case 1, sum == key
            if(sum == key) {
                result[0] = left;
                result[1] = right;
                done = true;
                return result;
            } // case 2: sum < key
            else if(sum < key) {
                right++;
                sum += arr[right];
            } // case 3: sum > key
            else {
                sum -= arr[left];
                left++;
            }
        }

        return result;
    }
}
