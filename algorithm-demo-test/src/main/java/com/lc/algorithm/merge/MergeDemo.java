package com.lc.algorithm.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 合并算法
 */
public class MergeDemo {

    /**
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int[] temp = intervals[i];
            queue.add(temp);
        }
        ArrayList<int[]> ints = new ArrayList<int[]>();
        int[] tmep = queue.poll();
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int end = tmep[1];
            if (end >= next[0] && end <= next[1]) {
                int[] newArr = {tmep[0], next[1]};

               // queue.add(newArr);
                tmep = newArr;
            } else if (end >= next[0] && end > next[1]) {
                int[] newArr = {tmep[0], tmep[1]};
                //queue.add(newArr);
                tmep = newArr;
            } else {
                ints.add(tmep);
                tmep=next;
            }

        }
        ints.add(tmep);


        return ints.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] aa = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(aa);
        for(int i=0;i<merge.length;i++){
            System.out.println(Arrays.toString(merge[i]));

        }
    }

}
