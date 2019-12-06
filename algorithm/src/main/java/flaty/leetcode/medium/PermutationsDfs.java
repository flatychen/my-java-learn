package flaty.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// 全排列问题
// DFS 主要来源于，树的构建
public class PermutationsDfs {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> alls = new ArrayList<>(nums.length);
        this.permute(alls, new ArrayList<>(), nums,0);
        return alls;
    }


    public void permute(List<List<Integer>> all, List<Integer> tempList, int[] nums,int deep) {
        // 最后一行退出
        if (nums.length == tempList.size()) {
            all.add(tempList);
            System.out.println(Arrays.toString(tempList.toArray()));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 实际上就是一种剪枝行为 ，去除掉已经用过的。
            if (tempList.contains(nums[i])) {
                continue;

            }
            tempList.add(nums[i]);
            permute(all, tempList, nums,deep + 1);
            tempList.remove(tempList.size() - 1);

        }

    }


    public static void main(String[] args) {
        int[] a = IntStream.of(1, 2, 3).toArray();
        new PermutationsDfs().permute(a);
    }
}
