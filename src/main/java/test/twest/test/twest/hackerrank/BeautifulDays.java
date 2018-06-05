package test.twest.test.twest.hackerrank;

public class BeautifulDays {

    public static int reverse(int n) {
        String number = Integer.toString(n);
        String output = "";
        for (int i = number.length() - 1; i >= 0; i--)
            output += number.charAt(i);
        return Integer.parseInt(output);
    }


    public static int beautifulDays(int i, int j, int k) {
        int result = 0, max = Math.max(j, k);
        double resultLocal = 0d;


        for(int index = i; index <= j; index++) {
            int tmp = Math.abs(index - reverse(index));
            if(j > k) {
                // can be divised by k
                resultLocal = (tmp / (double) k);
                System.out.println("tmp=" + tmp + ", k=" + k + ", " + (tmp / k));

                if(Double.valueOf(Math.floor(resultLocal)).equals(Double.valueOf(Math.ceil(resultLocal)))) {
                    result++;
                }
            } else {
                resultLocal = (k / (double) tmp);
                if(Double.valueOf(Math.floor(resultLocal)).equals(Double.valueOf(Math.ceil(resultLocal)))) {
                    result++;
                }
            }
        }

        return result;
    }
}
