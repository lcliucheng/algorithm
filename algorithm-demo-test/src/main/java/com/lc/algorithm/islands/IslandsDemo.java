package com.lc.algorithm.islands;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liu cheng
 * @since 2020-04-20 09:07
 */
public class IslandsDemo {

    /**
     * 200. 岛屿数量
     * <p>
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * 11110
     * 11010
     * 11000
     * 00000
     * 输出: 1
     * 示例 2:
     * <p>
     * 输入:
     * 11000
     * 11000
     * 00100
     * 00011
     * 输出: 3
     * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
     */


    public static void search(int h, int w, char[][] grid, int i, int j) {
        if (i + 1 < w && grid[i + 1][j] == '1') {
            grid[i + 1][j] = 0;
            search (h, w, grid, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            grid[i - 1][j] = 0;
            search (h, w, grid, i - 1, j);
        }
        if (j + 1 < h && grid[i][j + 1] == '1') {
            grid[i][j + 1] = 0;
            search (h, w, grid, i, j + 1);
        }

        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            grid[i][j - 1] = 0;
            search (h, w, grid, i, j - 1);
        }

    }

    /**
     * DFS搜索
     */
    public static int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    grid[i][j] = 0;
                    search (grid[i].length, grid.length, grid, i, j);
                }
            }

        }

        return num;
    }

    /**
     * BFS搜索方式
     */
    public static int numIslands2(char[][] grid) {
        int num = 0;
        LinkedBlockingQueue<int[]> chars = new LinkedBlockingQueue<> (Integer.MAX_VALUE);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    grid[i][j] = '0';
                    int[] aa = {i, j};
                    chars.add (aa);
                    while (!chars.isEmpty ()) {
                        int[] poll = chars.poll ();
                        int y = poll[0];
                        int x = poll[1];
                        if (y + 1 < grid.length && grid[y + 1][x] == '1') {
                            int [] ii={y+1,x};
                            chars.add (ii);
                            grid[y+ 1][x] = '0';
                        }
                        if (y - 1 >=0 && grid[y - 1][x] == '1') {
                            int [] ii={y-1,x};
                            chars.add (ii);
                            grid[y - 1][x] = '0';
                        }
                        if (x - 1 >=0 && grid[y][x-1 ] == '1') {
                            int [] ii={y,x-1};
                            chars.add (ii);
                            grid[y][x - 1] = '0';
                        }
                        if (x + 1 < grid[y].length && grid[y][x+1] == '1') {
                            int [] ii={y,x+1};
                            chars.add (ii);
                            grid[y][x+1] = '0';
                        }
                    }

                }
            }

        }

        return num;
    }

    public static void main(String[] args) {
       /* char[][] uu = {{1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}};*/

        char[][] pp = {{'1', '0', '1', '1', '1'}, {'1', '0', '1', '0', '1'}, {'1', '1', '1', '0', '1'}};

        char[][] uu = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] oo = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        int i = numIslands2 (pp);
        System.out.println (i);

    }


}
