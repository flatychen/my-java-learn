package flaty.leetcode.easy;


/*
        Given nums = [2, 7, 11, 15], target = 9,
        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
*/

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class TowSum {

    public int[] simple(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    return new int[]{i, j};
                }

            }
        }
        return null;
    }

    public int[] map(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length * 2);
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);

        }
        return null;
    }



    public int[] sort(int[] nums, int target) {
        Map<Integer, List<Integer>> numIndex = new HashMap<>(nums.length * 2);
        for (int i = 0; i < nums.length; i++) {
            final int v = i;
            numIndex.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        Arrays.sort(nums);

        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            int sum = nums[begin] + nums[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                begin++;
            } else {
                List<Integer> iindexs = numIndex.get(nums[begin]);
                List<Integer> jindexs = numIndex.get(nums[end]);
                if (iindexs.size() == 1) {
                    return new int[]{iindexs.get(0), jindexs.get(0)};
                } else {
                    return new int[]{iindexs.get(0), iindexs.get(1)};
                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int nums[] = new int[]{2, 7, 11, 9, 4, 6};
        System.out.println(Arrays.toString(new TowSum().map(nums, 15)));
        ;
    }
}
