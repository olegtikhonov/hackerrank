package test.twest.test.twest.fb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZeroSumTripletTest {
    private ZeroSumTriplet zeroSumTriplet;

    @BeforeEach
    public void setUp() throws Exception {
        zeroSumTriplet = new ZeroSumTriplet();
    }

    @Test
    public void findTriplets() {
        int[] arr = new int[]{0, -1, 2, -3, 1};
        zeroSumTriplet.findTriplets(arr, arr.length);
    }
}