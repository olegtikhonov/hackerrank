package test.twest.algorithms;


import org.junit.jupiter.api.Test;

import java.util.logging.Logger;


public class RecursiveBinarySearchTest {
    private final Logger logger   = Logger.getLogger(RecursiveBinarySearchTest.class.getSimpleName());
    private RecursiveBinarySearch recursiveBinarySearch = new RecursiveBinarySearch();

    @Test
    public void searchAsc() {
        // should be sorted
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int searchKey  = 11;
        boolean result = recursiveBinarySearch.search(array, 0, array.length - 1, searchKey);
        logger.info("Is found: [" + searchKey + "] " + result);
        searchKey  = 4;
        result = recursiveBinarySearch.search(array, 0, array.length - 1, 5);
        logger.info("Is found: [" + searchKey + "] " + result);
    }

    @Test
    public void searchDesc() {
        // should be sorted
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int searchKey  = 11;
        boolean result = recursiveBinarySearch.search(array, 0, array.length - 1, searchKey);
        logger.info("Is found: [" + searchKey + "] " + result);
        searchKey  = 4;
        result = recursiveBinarySearch.search(array, 0, array.length - 1, 5);
        logger.info("Is found: [" + searchKey + "] " + result);
    }
}