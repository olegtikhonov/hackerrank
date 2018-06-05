package test.twest;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class AnagramMakerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCalculate() {
		String src = "cde";
		String dst = "abc";

		int counter = AnagramMaker.calculate(src, dst);
		System.out.println(counter);
	}

	@Test
	public void testBirthdayCake() {
		int yearOld = 4;
		int[] candies = { 3, 2, 1, 3 };

		System.out.println(WeirdChecker.birthdayCakeCandles(yearOld, candies));
	}

	@Test
	public void testTimeConverter() {
		String in = "07:05:45PM";
		System.out.println(WeirdChecker.timeConversion(in));
	}

	@Test
	public void testIndexCalculation() {
		int d = 4, lo, hi, tmp;
		int[] ar = { 1, 2, 3, 4, 5 };

        ar = LeftRotation.leftRotate(ar, d);
		System.out.println(Arrays.toString(ar));
	}
}
