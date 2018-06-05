package test.twest;

/**
 * Kadane's Algorithm:
 * 
 * Initialize:
 * max_so_far = 0
 * max_ending_here = 0
 * Loop for each element of the array
 * (a) max_ending_here = max_ending_here + a[i]
 * (b) if(max_ending_here < 0)
 *      max_ending_here = 0
 * (c) if(max_so_far < max_ending_here)
 *      max_so_far = max_ending_here
 * return max_so_far
 * 
 * Simple idea of the Kadane's algorithm is to look for all positive contiguous segments of the array 
 * (max_ending_here is used for this). And keep track of maximum sum contiguous segment among all positive 
 * segments (max_so_far is used for this). Each time we get a positive sum compare it with max_so_far and 
 * update max_so_far if it is greater than max_so_far
 */
public class FindMaxSubArray {
	enum LOC {
		LEFT, RIGHT, SUM
	}
	
	public static int[] kadane(int[] array) {
		int maxSoFar = 0, maxEndingHere = 0, lastSeen = -1;
		int[] result = new int[2];
		
		for(int i = 0; i < array.length; i++) {
			maxEndingHere = maxEndingHere + array[i];
			
			if(maxEndingHere < 0) {
				maxEndingHere = 0;
			}
			
			if(maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
				lastSeen = i;
			}
		}
		
		result[0] = lastSeen;
		result[1] = maxSoFar;
		
		return result;
	}
	
	public static int[] findMaxSubarray(int[] array) {
		int[] result = new int[3];
		boolean isDone = false;
		int localSum = 0, startIndex = -1;
		int[] local = kadane(array);
		int lastSeen = local[0];
		
		while (!isDone && lastSeen > 0) {
			localSum += array[lastSeen];
			
		    if(localSum == local[1]) {
		    	isDone = true;
		    	startIndex = lastSeen;
		    }
		    
		    lastSeen--;
		}
		
		init(result, startIndex, local[0], local[1]);
		
		return result;
	}
	
	public static int[] findMaxSubbarray(int[] array, int low, int high) {
		int[] result = new int[3];
		int mid = 0;
		
		if(low == high) {
			init(result, low, high, array[low]);
		} else {
			mid = (int) Math.floor((low + high) / 2);
			int[] leftResult = findMaxSubbarray(array, low, mid);
			int[] rightResult = findMaxSubbarray(array, mid + 1, high);
			int[] crossResult = findMxCrossingSubarray(array, low, mid, high);

			if(leftResult[LOC.SUM.ordinal()] >= rightResult[LOC.SUM.ordinal()] && leftResult[LOC.SUM.ordinal()] >= crossResult[LOC.SUM.ordinal()]) {
				return leftResult;
			} else if(rightResult[LOC.SUM.ordinal()] >= leftResult[LOC.SUM.ordinal()] && rightResult[LOC.SUM.ordinal()] >= crossResult[LOC.SUM.ordinal()]) {
				return rightResult;
			} else {
				return crossResult;
			}
		}
		return result;
	}
	
	private static int[] findMxCrossingSubarray(int[] array, int low, int mid, int high) {
		int[] result = new int[3];
		int leftSum = Integer.MIN_VALUE, sum = 0, maxLeft = 0, rightSum = Integer.MIN_VALUE, maxRight = 0;
		
		for(int i = mid; i > low; i--) {
			sum = sum + array[i];
			if(sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		
		sum = 0;
		for(int j = mid + 1; j < high; j++) {
			sum = sum + array[j];
			if(sum > rightSum) {
				rightSum = sum;
				maxRight = j;
			}
		}
		
		init(result, leftSum, maxLeft, rightSum + maxRight);
		return result;
	}

	private static void init(int[] result, int low, int high, int sum) {
		result[LOC.LEFT.ordinal()] = low;
		result[LOC.RIGHT.ordinal()] = high;
		result[LOC.SUM.ordinal()] = sum;
	}
}
