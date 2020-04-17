package com.lc.algorithm.merge;

import java.util.*;

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

        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort (intervals, (v1, v2) -> v1[0] - v2[0]);
        Queue<int[]> queue = new LinkedList<int[]> ();
        ArrayList<int[]> ints = new ArrayList<int[]> ();
        for (int i = 0; i < intervals.length; i++) {
            int[] temp = intervals[i];
            queue.add (temp);
        }

        int[] tmep = queue.poll ();
        while (!queue.isEmpty ()) {
            int[] next = queue.poll ();
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
                ints.add (tmep);
                tmep = next;
            }

        }
        ints.add (tmep);


        return ints.toArray (new int[0][0]);
    }

    public static int[][] merge2(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
       // return res;
        return Arrays.copyOf(res, idx + 1);
    }



    public static void main(String[] args) {
        int[][] aa = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
       // int[][] aa = {};
        int[][] merge = merge2 (aa);
        for (int i = 0; i < merge.length; i++) {
            System.out.println (Arrays.toString (merge[i]));

        }
    }

}
