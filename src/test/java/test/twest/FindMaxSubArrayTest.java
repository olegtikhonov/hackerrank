package test.twest;


import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;


public class FindMaxSubArrayTest {
	static final int[] array = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindMaxSubbarray() {
		int[] result = FindMaxSubArray.findMaxSubbarray(array, 0, array.length - 1);
		System.out.println(Arrays.toString(result));
	}
	
	@Test
	public void testKadane() {
        System.out.println(Arrays.toString(FindMaxSubArray.findMaxSubarray(array)));		
        
	}

}
