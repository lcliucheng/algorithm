package com.lc.algorithm.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liu cheng
 * @since 2020-04-17 09:52
 */
public class SearchDemo {


    /**
     * 查找离0距离
     *输入：
     * {0,  0,  1,  0,  1,  1,  1,  0,  1,  1},
     * {1,  1,  1,  1,  0,  1,  1,  1,  1,  1},
     * {1,  1,  1,  1,  1,  0,  0,  0,  1,  1},
     * {1,  0,  1,  0,  1,  1,  1,  0,  1,  1},
     * {0,  0,  1,  1,  1,  0,  1,  1,  1,  1},
     * {1,  0,  1,  1,  1,  1,  1,  1,  1,  1},
     * {1,  1,  1,  1,  0,  1,  0,  1,  0,  1},
     * {0,  1,  0,  0,  0,  1,  0,  0,  1,  1},
     * {1,  1,  1,  0,  1,  1,  0,  1,  0,  1},
     * {1,  0,  1,  1,  1,  0,  1,  1,  1,  0}
     *
     *
     *输出:
     * [0,  0,  1,  0,  1,  2,  1,  0,  1,  2],
     * [1,  1,  2,  1,  0,  1,  1,  1,  2,  3],
     * [2,  1,  2,  1,  1,  0,  0,  0,  1,  2],
     * [1,  0,  1,  0,  1,  1,  1,  0,  1,  2],
     * [0,  0,  1,  1,  1,  0,  1,  1,  2,  3],
     * [1,  0,  1,  2,  1,  1,  1,  2,  1,  2],
     * [1,  1,  1,  1,  0,  1,  0,  1,  0,  1],
     * [0,  1,  0,  0,  0,  1,  0,  0,  1,  2],
     * [1,  1,  1,  0,  1,  1,  0,  1,  0,  1],
     * [1,  0,  1,  1,  1,  0,  1,  2,  1,  0],
     *
     *采用BFS广度优先搜索算法
     *
     */
    public static int[][] updateMatrix(int[][] matrix) {
        // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
        Queue<int[]> queue = new LinkedList<> ();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer (new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty ()) {
            int[] point = queue.poll ();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer (new int[]{newX, newY});
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] aa={{0,0,0},{0,1,0},{1 ,1 ,1}};
        int [][]ee={{0,0,1,0,1,1,1,0,1,1},{1,1,1,1,0,1,1,1,1,1},{1,1,1,1,1,0,0,0,1,1},{1,0,1,0,1,1,1,0,1,1},{0,0,1,1,1,0,1,1,1,1},{1,0,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,0,1,0,1},{0,1,0,0,0,1,0,0,1,1},{1,1,1,0,1,1,0,1,0,1},{1,0,1,1,1,0,1,1,1,0}};

        int[][] ints = updateMatrix (ee);
        for(int i=0;i<ints.length;i++){
            System.out.println (Arrays.toString (ints[i]));
        }
    }

}
