package test.twest;


/**
 * A left rotation operation on an array of size shifts each of the array's
 * elements unit to the left. For example, if 2 left rotations are performed on
 * array [1, 2, 3, 4, 5], then the array would become [3, 4, 5, 1, 2].
 * 
 * Constrains:
 * 1 <= d <= n
 *
 */
public class LeftRotation {
	
	public static int[] leftRotate(int[] src, int d) {
		int tmp;
		for(int i = 0; i < d; i++) {
			tmp = src[0];
			for(int j = 1; j < src.length; j++) {
				src[j - 1] = src[j];
			}
			src[src.length - 1] = tmp;
		}
		
		return src;
	}
}
