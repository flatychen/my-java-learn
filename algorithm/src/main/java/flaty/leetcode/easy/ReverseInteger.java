package flaty.leetcode.easy;


import lombok.extern.slf4j.Slf4j;

/**
 * 回文检测
 * Input: 121
 * Output: true
 */
@Slf4j
public class ReverseInteger {

    public int reverse(int x) {
        boolean flag = x < 0 ? true : false;
        x = flag ? -x : x;
        long n = 0;
        while (x > 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }

       return n >= Integer.MAX_VALUE ? 0 : (int) (flag ? -n : n);
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new ReverseInteger().reverse(1563847412));
    }

}
