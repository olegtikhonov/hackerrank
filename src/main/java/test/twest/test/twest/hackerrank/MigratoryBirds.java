package test.twest.test.twest.hackerrank;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * You have been asked to help study the population of birds migrating across the continent. Each type of bird you are
 * interested in will be identified by an integer value. Each time a particular kind of bird is spotted, its id number
 * will be added to your array of sightings. You would like to be able to find out which type of bird is most common
 * given a list of sightings.If two or more types of birds are equally common, choose the type with the smallest ID number.
 */
public class MigratoryBirds {

    public static int migratoryBirds(int n, int[] ar) {
        int counter = Integer.MAX_VALUE, key = 0;
        // Creates a map of frequencies
        Map<Integer, Integer> frequencies = new HashMap<>();
        // Creates a map with frequencies
        for(int i = 0; i < ar.length; i++) {
            key = ar[i];
            if(!frequencies.containsKey(key)) {
                frequencies.put(key, 1);
            } else {
                frequencies.put(key, frequencies.get(key) + 1);
            }
        }
        // Finds a max among all values
        int max = Integer.MIN_VALUE;
        for(Integer k : frequencies.keySet()) {
            if(max < frequencies.get(k)) {
                max = frequencies.get(k);
            }
        }
        // We have a maximum, now finds a lowest ID
        for(Integer k : frequencies.keySet()) {
            if(max == frequencies.get(k) && (counter > k)) {
                counter = k;
            }
        }

        return counter;
    }
}
