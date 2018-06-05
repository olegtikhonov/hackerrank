package test.twest.test.twest.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class SockMerchant {
    public static int sockMerchant(int n, int[] ar) {
        int result = 0, key = Integer.MIN_VALUE, value = Integer.MIN_VALUE;
        // this one will hold a key as a color, and the second as a counter
        Map<Integer, Integer> backets = new HashMap<>();

        for(int i = 0; i < n; i++) {
            key = ar[i];
            if(!backets.containsKey(key)) {
                backets.put(key, 1);
            } else {
                value = backets.get(key) + 1;
                backets.put(key, value);
            }
        }

        for (Integer kl : backets.keySet()) {
            value = backets.get(kl) / 2;
            if((value) >= 1 ) {
                result += value;
            }
        }

        return result;
    }
}
