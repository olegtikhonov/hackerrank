package test.twest.test.twest.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BonAppetit {

    public static void checkTheBill(int n, int k, List<Integer> array, int charged) {
        int sum = 0;

        for (int item = 0; item < n; item++) {
            if(k != item) {
                sum += array.get(item);
            }
        }

        int actual = sum / 2;

        if(actual == charged) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println((charged - actual));
        }
    }


    public static void main(String[] args) {
        // The first line contains two space-separated integers and , the number of items ordered and the -based index of the item that Anna did not eat.
        // The second line contains space-separated integers where bill[i] < 0 <= i < n
        // The third line contains an integer, , the amount of money that Brian charged Anna for her share of the bill.
        Scanner sc = new Scanner(System.in);
        String[] firstLine = sc.nextLine().split(" ");
        int n = Integer.valueOf(firstLine[0]);
        int k = Integer.valueOf(firstLine[1]);

        String[] secondLine = sc.nextLine().split(" ");
        List<Integer> array = new ArrayList<>();
        for(String str : secondLine) {
            array.add(Integer.valueOf(str));
        }

        int charged = sc.nextInt();
        checkTheBill(n, k, array, charged);
        //System.out.println(n + ", k=" + k + ", array:=" + array + ", charged:=" + charged);

    }
}
