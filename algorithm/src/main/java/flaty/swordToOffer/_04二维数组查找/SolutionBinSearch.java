package flaty.swordToOffer._04二维数组查找;

import java.util.Arrays;

/**
 * @author flaty-hp
 * @date 2020/5/25
 */
public class SolutionBinSearch {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            result  =  Arrays.binarySearch(matrix[i], target);
            if (result > 0) {
                return true;
            }
        }
        return false;
    }
}

