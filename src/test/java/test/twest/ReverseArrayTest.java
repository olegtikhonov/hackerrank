package test.twest;

import org.junit.Before;
import org.junit.Test;


public class ReverseArrayTest {
	private ReverseArray reverseArray;

	@Before
	public void setUp() throws Exception {
		reverseArray = new ReverseArray();
	}

	@Test
	public void testReverse() {
		int[] array = {1, 4, 3, 2};
		StringBuffer sb = reverseArray.reverse(array, new StringBuffer(), array.length);
		System.out.println(sb.toString());
	}

}
