package test.twest;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class WeirdChecker {
	
	public final static String WEIRD = "Weird";
	public final static String NOT_WEIRD = "Not Weird";
			
	
    public static String timeConversion(String s) {
        try {
        	SimpleDateFormat dateParser = new SimpleDateFormat("hh:mm:ssa");
            SimpleDateFormat dateFormater = new SimpleDateFormat("HH:mm:ss");
			return dateFormater.format(dateParser.parse(s));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return s;
    }
	
	// What is time complexity O(n) or O(nLog n)
    static int birthdayCakeCandles(int n, int[] ar) {
    	int max = Integer.MIN_VALUE;
    	int counter = 0;
    	
    	
    	for(int i = 0; i < ar.length; i++) {
    		if(max < ar[i]) {
    			max = ar[i];
    			counter = 1;
    		} else if(ar[i] == max){
    			counter++;
    		}
    	}
    	
		return counter;
    }
	
	public static String checkIfWeird(int number) {
		if((number % 2) != 0) {
			return WEIRD;
		}
		
		if(number > 2 && number <= 5) {
			return NOT_WEIRD;
		} else if(number > 6 && number <= 20) {
			return WEIRD;
		} 
		
		return NOT_WEIRD;
	}
}
