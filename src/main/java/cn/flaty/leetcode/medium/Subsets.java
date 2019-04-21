package cn.flaty.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// 子集问题
public class Subsets {


    public List<List<Integer>> Subsets(int[] nums) {
        List<List<Integer>> alls = new ArrayList<>(nums.length);
        Arrays.sort(nums);
        this.Subsets(alls, new ArrayList<>(), 0, nums);
//        this.backtrack(alls, new ArrayList<>(), nums, 0);
        return alls;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        System.out.println(Arrays.toString(tempList.toArray()));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    public void Subsets(List<List<Integer>> all, List<Integer> tempList, int deep, int[] nums) {
        // 最后一行退出
//        all.add(new ArrayList<>(tempList));

        if (deep <= nums.length) {
            System.out.println(Arrays.toString(tempList.toArray()));
        }

        for (int i = deep; i < nums.length; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }

            tempList.add(nums[i]);
            Subsets(all, tempList, i + 1, nums);
            tempList.remove(tempList.size() - 1);

        }


    }


    public static void main(String[] args) {
        int[] a = IntStream.of(1, 2, 2).toArray();
        List<List<Integer>> data = new Subsets().Subsets(a);
        System.out.println(data);
    }
}
