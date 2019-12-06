package flaty.leetcode.easy;



import lombok.extern.slf4j.Slf4j;

/**
 *
 * 回文检测
 * Input: 121
 * Output: true
 */
@Slf4j
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = Integer.toString(x);
        char[] chars = str.toCharArray();
        if (chars.length == 1) {
            return true;
        }
        for (int i = 0; i < chars.length / 2; i++) {
            if(chars[i] != chars[chars.length-i-1]){
                return false;
            }
            if (chars[i] == chars[chars.length - i - 1] && i == (chars.length / 2-1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println( new PalindromeNumber().isPalindrome(0));

    }

}
