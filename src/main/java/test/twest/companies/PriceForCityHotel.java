package test.twest.companies;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * We have a number of days a person wants to spend in each city
 *
 * numberOfDaysPerCity
 * a total sum to spend in all cities
 *
 * "Paris": {20, 10, 13, 56}
 * "London": {34, 2, 45, 45}
 * "Berlin": {12, 20, 45, 67}
 *
 * Generate all possible permutations
 * for each permutation calculate total cost
 * if number is less or equal to the total wanted to spend, add to the map result
 *
 *
 */
public class PriceForCityHotel {
    public List<String[]> permuteGenerator(String[] arr, int n) {
        if (n <= 1) {
            List<String[]> result = new ArrayList<>();
            result.add(Arrays.copyOf(arr, arr.length));
            return result;
        } else {
            List<String[]> result = new ArrayList<>();
            for (String[] i : permuteGenerator(arr, n - 1)) {
                result.add(Arrays.copyOf(i, i.length));
            }
            for (int i = 0; i < n - 1; i++) {
                if (n % 2 == 0) {
                    String temp = arr[i];
                    arr[i] = arr[n - 1];
                    arr[n - 1] = temp;
                } else {
                    String temp = arr[0];
                    arr[0] = arr[n - 1];
                    arr[n - 1] = temp;
                }
                for (String[] k : permuteGenerator(arr, n - 1)) {
                    result.add(Arrays.copyOf(k, k.length));
                }
            }
            return result;
        }
    }

    public List<Map<String[], List<Integer>>> getRanking(Map<String, int[]> hotels, int numberOfDaysPerCity) {
        List<Map<String[], List<Integer>>> result = new ArrayList<>();

        // Gets all cities
        String[] cities = new String[hotels.keySet().size()];
        AtomicInteger inx = new AtomicInteger();
        hotels.forEach((keys, values) -> {
            cities[inx.getAndIncrement()] = keys;
        });

        List<String[]> citiesPerms = permuteGenerator(cities, cities.length);

        for(int i = 0; i < citiesPerms.size(); i++) {
            String[] cityPerm = citiesPerms.get(i);
            List<Integer> localPrices = new ArrayList<>();

            for(int j = 0; j < cityPerm.length; j++) {
                String city = cityPerm[j];//city in ith
                int[] prices = hotels.get(city);
                int startDay = j * numberOfDaysPerCity;
                int endDay = startDay + numberOfDaysPerCity;
                localPrices.add(calculatePrices(startDay, endDay, prices));
            }
            Map<String[], List<Integer>> tmp = new HashMap<>();
            tmp.put(cityPerm, localPrices);
            result.add(tmp);
        }
        return result;
    }


    private int calculatePrices(int startDay, int endDay, int[] prices) {
        int localSum = 0;

        if(startDay >= prices.length || endDay >= prices.length)
            return -1;


        for(int i = startDay; i < endDay; i++) {
            localSum += prices[i];
        }
        return localSum;
    }


    public static void main(String[] args) {
        PriceForCityHotel priceForCityHotel = new PriceForCityHotel();
        int numberOfDaysPerCity = 3;

        Map<String, int[]> hotels = new HashMap<>();
        hotels.put("Paris", new int[] {20, 10, 13, 56});
        hotels.put("London", new int[] {34, 2, 45, 45});
        hotels.put("Berlin", new int[] {12, 20, 45, 67});

        List<Map<String[], List<Integer>>> ratings = priceForCityHotel.getRanking(hotels, numberOfDaysPerCity);
        System.out.println(ratings);

        TreeMap<String, Integer> fff = new TreeMap<>();
    }
}
