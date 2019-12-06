package flaty.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// 子集问题
public class Subsets2 {


    public List<List<Integer>> Subsets(int[] nums) {
        List<List<Integer>> alls = new ArrayList<>(nums.length);
        Arrays.sort(nums);
        this.Subsets(alls, new ArrayList<>(), 0, nums);
        return alls;
    }


    public void Subsets(List<List<Integer>> all, List<Integer> tempList, int deep, int[] nums) {
        // 最后一行退出

        if (deep == nums.length) {
            all.add(new ArrayList<>(tempList));
        }

        Subsets(all, tempList, deep + 1, nums);


        tempList.add(nums[deep]);
        Subsets(all, tempList, deep + 1, nums);


        tempList.remove(tempList.size() - 1);


    }


    public static void main(String[] args) {
        int[] a = IntStream.of(1, 2, 2).toArray();
        List<List<Integer>> data = new Subsets2().Subsets(a);
        System.out.println(data);
    }
}
