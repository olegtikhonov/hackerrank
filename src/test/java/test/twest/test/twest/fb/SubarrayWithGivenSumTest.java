package test.twest.test.twest.fb;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubarrayWithGivenSumTest {
    private SubarrayWithGivenSum subarrayWithGivenSum;

    @BeforeEach
    public void setUp() {
        subarrayWithGivenSum = new SubarrayWithGivenSum();
    }

    @Test
    public void indexOf() {
        int[] exampleOne = {1,2,3,7,5};
        int searchKey = 12;
        int[] result = subarrayWithGivenSum.indexOf(exampleOne, searchKey);
        System.out.println(result[0] + " " + result[1] + ", SK:= " + searchKey);

        int[] exampleSecond = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        searchKey = 15;
        result = subarrayWithGivenSum.indexOf(exampleSecond, searchKey);
        System.out.println(result[0] + " " + result[1] + ", SK:= " + searchKey);
    }
}