package flaty.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * https://leetcode.com/problems/valid-parentheses/
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * <p>
 * 括号匹配
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        char[] c = s.toCharArray();
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('}', '{');
        charMap.put(']', '[');
        charMap.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            // 右边的，执行比较
            if (charMap.containsKey(c[i])) {
                if (stack.isEmpty()) {
                    return false;
                }
                char left = charMap.get(c[i]);
                if (left != stack.pop()) {
                    return false;
                }
                // 左边的，直接入栈
            } else {
                stack.push(c[i]);
            }
        }

        return stack.isEmpty();


    }


    public static void main(String[] args) {
        boolean result = new ValidParentheses().isValid("()[]{}");
        System.out.println(result);
    }

}

