package flaty.leetcode.medium;

import java.util.*;
import java.util.stream.IntStream;

// 全排列问题
// DFS 主要来源于，树的构建
public class PermutationsUniqueDfs {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> alls = new ArrayList<>(nums.length);
        Arrays.sort(nums);
        this.permute(alls, new ArrayList<>(), new boolean[nums.length], nums);
        return alls;
    }


    public void permute(List<List<Integer>> all, List<Integer> tempList, boolean[] used, int[] nums) {
        // 最后一行退出
        if (nums.length == tempList.size()) {
            all.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 实际上就是一种剪枝行为 ，去除掉已经用过的。
            if(used[i] || i > 0 && nums[i] == nums[i-1] && used[i - 1]) continue;
//            if (used[i] || (i>0 && nums[i] == nums[i-1] && used[i-1])) {
//                continue;
//
//            }
            tempList.add(nums[i]);
            used[i] = true;
            permute(all, tempList, used, nums);
            tempList.remove(tempList.size() - 1);
            used[i] = false;

        }

    }


    public static void main(String[] args) {
        int[] a = IntStream.of(6, 7, 7).toArray();
        List<List<Integer>> data = new PermutationsUniqueDfs().permute(a);
        System.out.println(data);
    }
}
