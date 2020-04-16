package com.lc.algorithm.merge;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * 合并算法
 */
public class MergeDemo {

    /**
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     */
    public static int[][] merge(int[][] intervals) {
        ArrayQueue<int[]> queue = new ArrayQueue<int[]>(Integer.MAX_VALUE);
        for(int i=0;i<intervals.length;i++){
            int [] temp=intervals[i];
            queue.add(temp);
        }


     /*   for(int i=1;i<queue.size();i++){
            int[] ints1 = queue.get(i);
            if(){

            }
        }*/


        return null;
    }

    public static void main(String[] args) {

    }

}
