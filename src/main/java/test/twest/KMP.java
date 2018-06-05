package test.twest;

/**
 * Knuth - Morris - Pratt. The basic idea behind KMP’s algorithm is: whenever we
 * detect a mismatch (after some matches), we already know some of the
 * characters in the text of next window.
 * lps[] that tells us count of characters to be skipped. 
 * Stands for Longest Proper Prefix.
 * 
 */
public class KMP {
	
	public int match(String text, String pattern) {
		
		// TODO: Check for nulls and emptiness
		if (text.length() < pattern.length()) {
			return -1;
		}
		
		int[] lps = computeLPSArray(pattern);
		int i = 0, j = 0;
		
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            
            if (j == pattern.length()) {
                System.out.println("Found pattern "+ "at index " + (i-j));
                // j = lps[j-1];
                return (i-j);
                
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j-1];
                } else {
                    i = i+1;
                }
            }
        }
		System.out.println("Not found.");
		return -1;
	}
	
	private int[] computeLPSArray(String pattern) {
		int[] lps = new int[pattern.length()];
		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		// the loop calculates lps[i] for i = 1 to M-1
		while (i < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {// (pat[i] != pat[len])
				// This is tricky. Consider the example.
				// AAACAAAA and i = 7. The idea is similar
				// to search step.
				if (len != 0) {
					len = lps[len - 1];
					// Also, note that we do not increment
					// i here
				} else {// if (len == 0)
					lps[i] = len;
					i++;
				}
			}
		}
		
		return lps;
	}

	public static void main(String[] args) {
		KMP kmp = new KMP();
		// Case 1: both are not null
		int response = kmp.match("kakodnajdajdizhakzvonar'gorodskojslomalfonar'", "ajdajdk");
		System.out.println(response);
		
		// Case 2: both are null
		response = kmp.match(null, null);
		System.out.println(response);

		
	}

}
