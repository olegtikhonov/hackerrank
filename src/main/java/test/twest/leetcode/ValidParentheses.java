package test.twest.leetcode;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *     Every close bracket has a corresponding open bracket of the same type.
 *
 *     Example 1:
 *
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> checker = new Stack<>();
        char[] brackets = s.toCharArray();

        for(char brkt : brackets) {
            if(brkt == '(' || brkt == '{' || brkt == '[') {
                checker.push(brkt);
            } else {
                if(!checker.isEmpty()) {
                    char opener = checker.peek();
                    char closure = getClosure(opener);
                    if(closure == brkt ) {
                        checker.pop();
                    }
                }
            }
        }
        return checker.isEmpty();
    }

    public char getClosure(char brkt) {
        switch (brkt) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return '_';
        }
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String firstInput = "()[]{}";
        System.out.println(validParentheses.isValid(firstInput));

        String invalid = "(]";
        System.out.println(validParentheses.isValid(invalid));
    }
}
