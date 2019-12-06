package flaty.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 全排列问题
public class Permutations {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> alls = new ArrayList<>(nums.length);
        this.permute(alls, nums, 0);
        return alls;
    }


    public void permute(List<List<Integer>> all, int[] nums, int index) {
        // 最后一行退出
        if (index == nums.length - 1) {
            List<Integer> one = IntStream.of(nums).boxed().collect(Collectors.toList());
            all.add(one);
            System.out.println(Arrays.toString(one.toArray()));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            this.swap(nums, index, i);
            permute(all, nums, index + 1);
            this.swap(nums, index, i);
        }

    }





    public void swap(int nums[], int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    public static void main(String[] args) {
        int[] a = IntStream.of(1, 2, 3).toArray();
        new Permutations().permute(a);
    }
}
