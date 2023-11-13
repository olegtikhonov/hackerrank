package test.twest.leetcode;

import org.junit.jupiter.api.Test;

public class CandyTest {

    @Test
    public void testCandy() {
        Candy candy = new Candy();
        int[] ratings = {1,0,2};
        int result = candy.candy(ratings);
        System.out.println(result);

        int[] ratingsNewCase = {1, 2, 2};
        result = candy.candy(ratingsNewCase);
        System.out.println(result);
    }
}