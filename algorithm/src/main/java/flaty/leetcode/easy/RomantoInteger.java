package flaty.leetcode.easy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomantoInteger {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        List<String> romans = new ArrayList<>();
        Collections.addAll(romans, "I", "V", "X", "L", "C", "D", "M");
        List<Integer> romanValues = new ArrayList<>();
        Collections.addAll(romanValues, 1, 5, 10, 50, 100, 500, 1000);
        int i = 0, lastValue = 1000, sum = 0;
        while (i < chars.length) {
            int value = romanValues.get(romans.indexOf(String.valueOf(chars[i])));
            if (value < lastValue) {
                sum= sum - 2 * lastValue;
            }
            lastValue = value;
            sum += value;
            i++;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new RomantoInteger().romanToInt("IX"));
        System.out.println(new RomantoInteger().romanToInt("MCMXCIV"));
        System.out.println(new RomantoInteger().romanToInt("LVIII"));
    }

}
