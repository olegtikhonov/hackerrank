package test.twest.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * need to calculate binomi coefficients
 * Example 1:
 * <p>
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * Example 2:
 * <p>
 * Input: numRows = 1
 * Output: [[1]]
 */
public class EasyPascalTriangle {

    public int binomi(int n, int k) {
        if ((n == k) || (k == 0)) {
            return 1;
        } else {
            return binomi(n - 1, k) + binomi(n - 1, k - 1);
        }
    }

    List<Integer> calcRaw(int numRaw) {
        List<Integer> result = new ArrayList<>(1);
        if(numRaw == 0) {
            result.add(1);
            return result;
        } else {
            for(int kth = 0; kth <= numRaw; kth++) {
                result.add(binomi(numRaw, kth));
            }
        }
        return result;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int raw = 0; raw < numRows; raw++) {
            result.add(calcRaw(raw));
        }
        return result;
    }

    public static void main(String[] args) {
        EasyPascalTriangle easyPascalTriangle = new EasyPascalTriangle();
        int numOfRaws = 5;
        List<List<Integer>> result = easyPascalTriangle.generate(numOfRaws);
        System.out.println(result);
    }
}
