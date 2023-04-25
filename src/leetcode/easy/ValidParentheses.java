package leetcode.easy;

import java.util.Stack;

public class ValidParentheses {
    /* LeetCode Question 20 - Valid Parentheses */

    public boolean isValid(String s) {
        char[] parentheses = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char parenthesis : parentheses) {
            if (stack.isEmpty()) {
                stack.push(parenthesis);
            } else {
                if (parenthesis == ')' && stack.peek() == '(')
                    stack.pop();
                else if (parenthesis == ']' && stack.peek() == '[')
                    stack.pop();
                else if (parenthesis == '}' && stack.peek() == '{')
                    stack.pop();
                else stack.push(parenthesis);
            }

        }
        return stack.isEmpty();
        }
    }

