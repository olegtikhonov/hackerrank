package test.twest.test.twest.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Pangrams {
    private static final String OK = "pangram";
    private static final String NOT_OK = "not pangram";
    private static final int NUMBER_ABC = 26;

    public static String pangrams(String s) {
        char[] chars = s.toLowerCase().replaceAll(" ", "").toCharArray();
        Map<Character, Integer> holder = new HashMap<>();

        for(char ch : chars) {
            if(!holder.containsKey(ch)) {
                holder.put(ch, 1);
            }else {
                holder.put(ch, holder.get(ch) + 1);
            }
        }

        return (holder.keySet().size() == NUMBER_ABC) ? OK : NOT_OK;
    }
}
