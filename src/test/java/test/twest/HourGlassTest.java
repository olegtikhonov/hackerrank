package test.twest;


import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


public class HourGlassTest {
	private int matrix[][] = {{1, 1, 1, 0, 0, 0}, 
			                  {0, 1, 0, 0, 0, 0}, 
			                  {1, 1, 1, 0, 0, 0},
			                  {0, 0, 2, 4, 4, 0},
			                  {0, 0, 0, 2, 0, 0},
			                  {0, 0, 1, 2, 4, 0}};
//	private int matrix[][] = {
//			{1, 1, 1, 0, 0, 0}, 
//            {0, 1, 0, 0, 0, 0}, 
//            {1, 1, 1, 0, 0, 0},
//            {0, 9, 2,-4,-4, 0},
//            {0, 0, 0,-2, 0, 0},
//            {0, 0,-1,-2,-4, 0}};
//	private int matrix[][] = {
//			{-1,-1, 0,-9,-2,-2}, 
//            {-2,-1,-6,-8,-2,-5}, 
//            {-1,-1,-1,-2,-3,-4},
//            {-1,-9,-2,-4,-4,-5},
//            {-7,-3,-3,-2,-9,-9},
//            { 0, 0,-1,-2,-4, 0}};

	private HourGlass hourGlass;
	
	@Before
	public void setUp() throws Exception {
		hourGlass = new HourGlass(matrix);
	}

//	@Test
//	public void testIsHG() {
//		for(int i = 0; i < matrix.length; i++) {
//			for(int j = 0; j < matrix.length; j++) {
//				System.out.println(String.format("i=%d, j=%d", i, j) + ", " + hourGlass.isHG(i, j));
//			}
//		}
//	}

	@Test
	public void testSum() {
		List<Integer> result= new ArrayList<>();
		int local[] = null;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				int tmpSum = hourGlass.sum(i, j);
				if(tmpSum != Integer.MIN_VALUE) {
					result.add(tmpSum);
				}
			}
		}
		
		local = new int[result.size()];
		
		int index = 0;
		for(Integer num : result) {
		    local[index++] = num;	
		}
		System.out.println(hourGlass.findMax(local));
	}
}
