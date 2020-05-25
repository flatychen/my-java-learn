package flaty.swordToOffer._03重复数字;

import java.util.HashSet;
import java.util.Set;

/**
 * @author flaty-hp
 * @date 2020/5/24
 */
public class SolutionSet {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> sets = new HashSet<>(nums.length * 2);
        for (int i = 0; i < nums.length; i++) {
            if (sets.contains(nums[i])) {
                return nums[i];
            } else {
                sets.add(nums[i]);
            }
        }
        return -1;
    }
}

