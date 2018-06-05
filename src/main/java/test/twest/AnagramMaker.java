package test.twest;

import java.util.Arrays;

/**
 * Alice recently started learning about cryptography and wants to create her
 * own encryption method. Alice decides to generate a random seed for her
 * encryption by transforming two strings into anagrams by removing characters
 * from each string as necessary. Two words are anagrams of each other if the
 * first word's letters can be rearranged to form the second word. So, the two
 * strings must have the same characters (in any order) and the same length. For
 * instance, given the strings and , Alice can remove the from to have which is
 * an anagram of . The minimum number of operations performed to create the
 * anagram is , so that will be her seed value. Your challenge is to complete a
 * line of code to calculate this seed value. You will be given two strings and
 * must cumulate the minimum number of characters that must be removed from each
 * string to create an anagram.
 * 
 * examples:
 * cba, ab  - c should be removed. common ba
 * cde, abc - de and ab should be removed
 */
public class AnagramMaker {
	
	public static boolean isAnagram(char[] src, char[] dst) {
		
		if(src.length == dst.length) {
			int counter = 0;
			for(char c : src) {
				int result = Arrays.binarySearch(dst, c);
				if(result > 0) {
					counter++;
				}
			}
			return (counter == src.length);
		}
		return false;
	}
	
	
	public static int checkAndCount(char[] first, char[] second) {
		int counter = 0;
		for(int i = 0; i < second.length; i++) {
			for(int j = 0; j < first.length; j++)
			if(first[i] == second[j]) {
				counter++;	
			}
		}
		
		return counter;
	}
	
	static int distance(String x, String y) {
		if (x.isEmpty()) {
			return y.length();
		}

		if (y.isEmpty()) {
			return x.length();
		}

		int substitution = calculate(x.substring(1), y.substring(1)) + costOfSubstitution(x.charAt(0), y.charAt(0));
		int insertion = calculate(x, y.substring(1)) + 1;
		int deletion = calculate(x.substring(1), y) + 1;

		return min(substitution, insertion, deletion);
	}

	public static int costOfSubstitution(char a, char b) {
		return a == b ? 0 : 1;
	}

	public static int min(int... numbers) {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < numbers.length; i++) {
			if(min > numbers[i]) {
				min = numbers[i];
			}
		}
		return min;
	}
	
	// cde abc
	// cde abc 
	public static int calculate(String src, String dst) {
		char[] first = src.toCharArray();
		char[] second = dst.toCharArray();
		
		int counter = 0;
		Arrays.sort(first);
		Arrays.sort(second);
		
		if(first.length > second.length) {
			counter = checkAndCount(first, second);
		} else if(second.length > first.length) {
			counter = checkAndCount(second, first);
		} else if(isAnagram(first, second)) {
			counter = distance(src, dst);
		} else {
			counter = checkAndCount(first, second);
		}
        		
		if(counter == first.length) {
			return second.length - counter;
		} else if(counter == second.length) {
			return first.length - counter;
		} else if(counter == 0) {
			return first.length + second.length;
		} else if(counter == 1) {
			return (second.length - counter) * 2;
		} else {
			return 0;
		}
	}
	
	
	
	// some case: when src > tar -> should check if src contains tar characters
	//            when src < tar -> should check if tar contains src characters
	//            when src = tar -> call is anagram
	//            when src null or empty -> ?
	//            when tar null or empty -> ?

}
