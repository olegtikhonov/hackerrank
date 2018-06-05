package test.twest.test.twest.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class LonelyInteger {
    public static int lonelyinteger(int[] a) {
        Map<Integer, Integer> helper = new HashMap<>();

        for (int number: a) {
            if(!helper.containsKey(number)) {
                helper.put(number, 1);
            } else {
                helper.put(number, helper.get(number) + 1);
            }
        }

        for(Integer key : helper.keySet()) {
            if(helper.get(key) == 1) {
                return key;
            }
        }
        return -1;

    }
}
