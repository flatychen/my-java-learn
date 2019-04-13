package cn.flaty.leetcode.easy;

/**
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * https://leetcode.com/problems/valid-parentheses/
 *
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 *
 * 括号匹配
 *
 */
public class ValidParentheses {


    public void print(int start, int max) {
        if (start >= max) {
            System.out.println(start);
            return;
        }
        System.out.println(start);
        print(start*2,max);
        System.out.println(start);

    }


    public static void main(String[] args) {


        new ValidParentheses().print(1,19);
    }

}

