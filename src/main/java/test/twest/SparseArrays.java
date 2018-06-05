package test.twest;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class SparseArrays {
   
	 
	public static void checkIfSparse(List<String> strings, List<String> queries) {
	    for(String query : queries) {
	        int frequency = 0;
	    	for(String str : strings) {
	        	if(str.equals(query)) {
	        		frequency++;
	        	}
	        }
	    	System.out.println(frequency);
	    }
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); 
		String local;
		List<String> strings = new LinkedList<>();
		List<String> queries = new LinkedList<>();
		
		int numberOfStrings = sc.nextInt() + 1;
		
		for(int i = 0; i < numberOfStrings; i++) {
			local = sc.nextLine();
			if(!local.isEmpty()) {
				strings.add(local);
			}
		}

		int numberOfQueries = sc.nextInt() + 1;
		
		while (numberOfQueries-- > 0) {
			local = sc.nextLine();
			if(!local.isEmpty()) {
				queries.add(local);
			}
		}
		
		checkIfSparse(strings, queries);
	}
}
