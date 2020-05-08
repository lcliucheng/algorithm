package com.lc.algorithm.dynamicprogramming;

/**
 * @author liu cheng
 * @since 2020-05-08 14:27
 */
public class MaximalSquare {
    /**
     * 221. 最大正方形
     * <p>
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * <p>
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     * <p>
     * 输出: 4
     */

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] dsp = new int[matrix.length][matrix[0].length];

        for (char i = 0; i < matrix.length; i++) {
            for (char j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dsp[i][j] = 1;
                    } else {
                        dsp[i][j] = Math.min (Math.min (dsp[i - 1][j], dsp[i][j - 1]), dsp[i - 1][j - 1]) + 1;
                    }
                    max = Math.max (max, dsp[i][j]);

                }
            }
        }
        return max * max;

    }

}
