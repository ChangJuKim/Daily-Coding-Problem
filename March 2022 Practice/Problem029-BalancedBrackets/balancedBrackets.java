/*
Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false.


CJ's notes:
Edge cases:
    1. Checking if you have too many open brackets (stack size is not empty at the end). 
    2. Checking if you have too many close brackets (stack size is empty when you need to pop).
    3. Checking empty string / strings with no brackets / other characters
*/

import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class balancedBrackets {
    private static final ArrayList<Character> open = new ArrayList<Character>(Arrays.asList('(', '{', '['));
    private static final ArrayList<Character> close = new ArrayList<Character>(Arrays.asList(')', '}', ']'));
    
    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (open.contains(current)) {
                stack.push(current);
            } else if (close.contains(current)) {
                int index = close.indexOf(current);
                if (stack.size() == 0 || open.get(index) != stack.pop()) {
                    return false;
                }
            }
            // Skip if it's not an open or close bracket
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("([])[]({})"));
        System.out.println(isBalanced("([)]"));
        System.out.println(isBalanced("((()"));
        System.out.println(isBalanced("12345"));
        System.out.println(isBalanced("{2312}[421](dsadas)"));
        System.out.println(isBalanced(""));
        System.out.println(isBalanced("[}[]()"));
        System.out.println(isBalanced("]"));
    }
}