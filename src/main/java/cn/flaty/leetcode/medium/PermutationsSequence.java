package cn.flaty.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PermutationsSequence {


    public String PermutationsSequence(int n, int k) {
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        List<String> alls = new ArrayList<>(nums.length);
        this.permute(alls, new ArrayList<>(), nums, k,0);
        return alls.get(k-1);
    }


    public void permute(List<String> all, List<Integer> tempList, int[] nums, int k,int sequence) {
        // 最后一行退出
        if (k == sequence+1) {
            return;
        }

        if (nums.length == tempList.size()) {
            StringBuilder sb = new StringBuilder();
            tempList.stream().forEach(v-> sb.append(v));
            all.add(sb.toString());
            sequence ++;
            System.out.println("::  " + sb.toString());
            System.out.print(":: sequence  " + sequence);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 实际上就是一种剪枝行为 ，去除掉已经用过的。
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            permute(all, tempList, nums, k,sequence);
            tempList.remove(tempList.size() - 1);

        }

    }


    public static void main(String[] args) {
        int[] a = IntStream.of(1, 2, 3).toArray();
        String r = new PermutationsSequence().PermutationsSequence(3, 3);
        System.out.println(r);
    }
}
