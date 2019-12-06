package flaty.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// 子集问题
public class SubsetsUnique {


    public List<List<Integer>> Subsets(int[] nums) {
        List<List<Integer>> alls = new ArrayList<>(nums.length);
        Arrays.sort(nums);
        this.Subsets(alls, new ArrayList<>(), 0, nums, new boolean[nums.length]);
        return alls;
    }


    public void Subsets(List<List<Integer>> all, List<Integer> tempList, int deep, int[] nums, boolean[] used) {
        // 最后一行退出
        all.add(new ArrayList<>(tempList));
        if (tempList.size() == nums.length) {
            return;
        }
        // 此处，i从树的深度开始计算.意味着，不重复计算以前的数据。
        //
        for (int i = deep; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i - 1] == nums[i] && !used[i-1]) {
                continue;
            }
            tempList.add(nums[i]);
            used[i] = true;
            Subsets(all, tempList, i + 1, nums, used);
            tempList.remove(tempList.size() - 1);
            used[i] = false;

        }


    }


    public static void main(String[] args) {
        int[] a = IntStream.of(1, 2, 2).toArray();
        List<List<Integer>> data = new SubsetsUnique().Subsets(a);
        System.out.println(data);
    }
}
