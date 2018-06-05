package test.twest.test.twest.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Preparation {

    public static void lessonOne() {
        Map<String, String> holder = new HashMap<>();

        for(int i = 0; i < 10; i++) {
            holder.put("ID" + i, String.valueOf(i));
        }

        for(String key : holder.keySet()) {
            System.out.println("key:=" + key + ", " + holder.get(key));
        }
    }
}
