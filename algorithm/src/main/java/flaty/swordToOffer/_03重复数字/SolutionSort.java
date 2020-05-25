package flaty.swordToOffer._03重复数字;

import java.util.Arrays;

/**
 * @author flaty-hp
 * @date 2020/5/24
 */
public class SolutionSort {

    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                return pre;
            }
            pre = nums[i];
        }
        return -1;
    }
}

