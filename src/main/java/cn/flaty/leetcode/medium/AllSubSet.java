package cn.flaty.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 全排列问题
public class AllSubSet {




    public void permute( int[] nums, int index) {
        // 最后一行退出
        if (index == nums.length - 1) {
            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, index, nums.length)));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            this.swap(nums, index+1, i);
            permute( nums, index + 1);
//            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, index + 1, nums.length)));
            this.swap(nums, index+1, i);
        }

    }


    public void swap(int nums[], int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    public static void main(String[] args) {
        int[] a = IntStream.of(1, 2).toArray();
        new AllSubSet().permute(a,0);
    }
}
