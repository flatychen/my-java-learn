package flaty.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationsSequence {


    public String PermutationsSequence(int n, int k) {
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        Object alls [] = new Object[2];
        alls[0] = new Integer(0);
        alls[1] = "";

        this.permute(alls , new ArrayList<>(), nums,k);
        return alls[1].toString();
    }


    public void permute(Object all[], List<Integer> tempList, int[] nums,int rank) {
        // 最后一行退出
        if (rank == Integer.parseInt(all[0].toString())) {
            return;
        }

        if (nums.length == tempList.size()) {
            StringBuilder sb = new StringBuilder();
            tempList.stream().forEach(v-> sb.append(v));
            all[1] = (sb.toString());
            all[0] = Integer.parseInt(all[0].toString()) + 1;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 实际上就是一种剪枝行为 ，去除掉已经用过的。
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            permute(all, tempList, nums,rank);
            tempList.remove(tempList.size() - 1);

        }

    }


    public static void main(String[] args) {
        String r = new PermutationsSequence().PermutationsSequence(4, 9);
        System.out.println(r);
    }
}
