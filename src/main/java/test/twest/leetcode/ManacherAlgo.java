package test.twest.leetcode;

/**
 *
 * The goal is to find the longest palindrome in the given string
 * Preparations:
 * To unify cases we have to insert additional symbol, say '#'
 *
 * Algorithm
 *
 *     Create a new string by inserting a special character (such as #) between each pair of characters in the original string.
 *     It ensures that every palindrome in the new string has an odd length.
 *     Initialize two variables: Center and right. The Center represents the Center of the palindrome we have found so far,
 *     and the right represents the rightmost boundary of this palindrome.
 *     Initialize an array p to store the length of the palindrome centered at each position in the new string.
 *     Initially, set all elements to zero.
 *     Loop through each position in the new string. At each position i, do the following: a. If i is less than right,
 *     set p[i] to the minimum of p[2 * center - i] and right - i. We can reuse information from previously discovered
 *     palindromes to avoid redundant work. b. Expand the palindrome centered at i as far as possible, updating p[i]
 *     accordingly. c. If the right boundary of this palindrome extends beyond the current value of the right, update the
 *     Center and right accordingly.
 *     Find the index of the maximum value in p. It represents the Center of the longest palindrome in the new string.
 *     Use the Center and the palindrome length to extract the corresponding substring from the original string.
 *
 */
public class ManacherAlgo {
    public String insertSign(Character sign, String orig) {
        StringBuilder sb = new StringBuilder();

        for(char ch : orig.toCharArray()) {
            sb.append(sign).append(ch);
        }
        sb.append(sign);//at the end
        return sb.toString();
    }

    public String removeSign(Character sign, String orig) {
        return orig.replaceAll(String.valueOf(sign), "");
    }


    public static void main(String[] args) {
        ManacherAlgo manacherAlgo = new ManacherAlgo();
        String caseEvenLen = "sasdfdsa";
        String result = manacherAlgo.insertSign('#', caseEvenLen);
        System.out.println(result + ", size= " + result.length());

        String caseOddLen = "qwewq";
        result = manacherAlgo.insertSign('&', caseOddLen);
        System.out.println(result + ", size= " + result.length());
    }
}
