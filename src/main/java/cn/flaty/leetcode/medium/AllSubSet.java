package cn.flaty.leetcode.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

// 全排列问题
public class AllSubSet {




    public void permute( int[] nums, int index) {
        // 最后一行退出
        if (index == nums.length ) {
            System.out.println("[]");
            System.out.println(nums[index]);
            return;
        }

        for (int i = index + 1 ; i < nums.length; i++) {
            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, index + 1, nums.length)));
            this.swap(nums, index, i);
            permute( nums, index + 1);
//            this.swap(nums, index, i);
//            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, index + 1, nums.length)));
//            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, index + 1, nums.length)));
//            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, index + 1, nums.length)));
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
