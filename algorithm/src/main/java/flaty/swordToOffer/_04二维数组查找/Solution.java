package flaty.swordToOffer._04二维数组查找;

/**
 * @author flaty-hp
 * @date 2020/5/25
 */
public class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j <= matrix[0].length - 1) {
            if (target > matrix[i][j]) {
                j++;
            } else if (target < matrix[i][j]) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}

