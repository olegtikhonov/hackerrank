package test.twest.test.twest.hackerrank;

public class BeautifulTriplets {

    public static int beautifulTriplets(int d, int[] arr) {
        int countOfTriples = 0;
        // i < j < k
        for(int i = 0; i < arr.length; i++) {
            for(int j = (i+1); j < arr.length; j++) {
                for(int k = (j+1); k < arr.length; k++) {
                    if((arr[j] - arr[i]) == (arr[k] - arr[j]) && (arr[k] - arr[j]) == d) {
                        countOfTriples++;
                    }
                }
            }
        }

        return countOfTriples;
    }

    // more effisient solution
    public static int efficientSolution(int d, int[] arr) {
        int countOfTriples = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            // Search other two elements
            // of AP with arr[i] as middle.
            for (int j = i - 1, k = i + 1; j >= 0 && k < arr.length; ) {
                // if a triplet is found
                if (arr[j] + arr[k] == 2 * arr[i]) {
                    System.out.println(arr[j] + " " + arr[i] + " " + arr[k]);
                    if ((arr[i] - arr[j]) == (arr[k] - arr[i]) && (arr[k] - arr[i]) == d) {
                        countOfTriples++;
                    }
                    // Since elements are distinct,
                    // arr[k] and arr[j] cannot form
                    // any more triplets with arr[i]
                    k++;
                    j--;
                }
                // If middle element is more move to
                // higher side, else move lower side.
                else if (arr[j] + arr[k] < 2 * arr[i]) {
                    k++;
                } else {
                    j--;
                }
            }
        }

        return countOfTriples;
    }
}
