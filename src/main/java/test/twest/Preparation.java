package test.twest;

import java.util.HashMap;
import java.util.Map;

public class Preparation {
    static Map<Integer, Integer> visited = new HashMap<>();


    public static int calculateFibonachi(int n) {
        if(n <= 1) {
            return n;
        }
        return calculateFibonachi(n - 1) + calculateFibonachi(n - 2);
    }

}
