package test.twest.algorithms;

public class RecursiveBinarySearch {

    boolean search(int[] array, int startIndex, int endIndex, int searchKey) {
        int middle = (startIndex + endIndex) / 2;

        if(startIndex >= endIndex) {
            return false;
        }

        // case: key is found
        if(array[middle] == searchKey) {
            return true;
        } else if(array[middle] < searchKey) {
            return search(array, middle + 1, endIndex, searchKey);
        } else {
            return search(array, startIndex , middle - 1, searchKey);
        }
    }
}
