package test.twest.test.twest.fb;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZeroSumTripletTest {
    private ZeroSumTriplet zeroSumTriplet;

    @Before
    public void setUp() throws Exception {
        zeroSumTriplet = new ZeroSumTriplet();
    }

    @Test
    public void findTriplets() {
        int[] arr = new int[]{0, -1, 2, -3, 1};
        zeroSumTriplet.findTriplets(arr, arr.length);
    }
}