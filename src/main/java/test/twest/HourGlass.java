package test.twest;

import java.util.Arrays;

/**
 * Given a 6x6 2D Array,: 
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 
 * We define an hourglass in to be a subset of values with indices falling in this pattern in 's graphical representation:
 * a b c
 *   d
 * e f g
 * 
 * This class should calculate sum of hourglass and return a maximim sum.
 */
public class HourGlass {
    private static final int SIZE = 6;
    private int[][] matrix;
    
    public HourGlass(int arr[][]) {
    	this.matrix = arr;
    }

    /**
     * Calculates a sum of hourglass.
     * 
     * @param rowIndex X coordinate.
     * @param colmIndex Y coordinate.
     * 
     * @return a summary of hourglass.
     */
    public int sum(int rowIndex, int colmIndex) {
    	if((rowIndex + 2) < SIZE && (colmIndex + 2) < SIZE) {
    		int sum = 0;
    		
    		sum += matrix[rowIndex][colmIndex];
    		sum += matrix[rowIndex][colmIndex + 1];
    		sum += matrix[rowIndex][colmIndex + 2];
    		
    		sum += matrix[rowIndex + 1][colmIndex + 1];
    		
    		sum += matrix[rowIndex + 2][colmIndex];
    		sum += matrix[rowIndex + 2][colmIndex + 1];
    		sum += matrix[rowIndex + 2][colmIndex + 2];
    		
    		return sum;
    	}
    	
    	return Integer.MIN_VALUE;
    }
    
    /**
     * Finds the biggest element,
     * 
     * @param numberArr an array of elements.
     * 
     * @return the biggest one.
     */
    public int findMax(int numberArr[]) {
    	if(numberArr == null) {
    		return -1;
    	}
    	
    	Arrays.sort(numberArr);
    	return numberArr[numberArr.length -1];
    }
}
