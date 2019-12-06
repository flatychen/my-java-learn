package flaty.leetcode.easy;


import lombok.extern.slf4j.Slf4j;

/**
 * 回文检测
 * Input: 121
 * Output: true
 */
@Slf4j
public class ReverseInteger2 {

    public int reverse(int x) {
        int n = 0;
        while (x != 0) {
            if (x > Integer.MAX_VALUE / 10 || (x == Integer.MAX_VALUE && x % 10 > 7)) {
                return 0;
            }
            if (x < Integer.MIN_VALUE / 10 || (x == Integer.MIN_VALUE && x % 10 < -8)) {
                return 0;
            }
            n = n * 10 + x % 10;
            x = x / 10;
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new ReverseInteger2().reverse(1563847412));
    }

}
