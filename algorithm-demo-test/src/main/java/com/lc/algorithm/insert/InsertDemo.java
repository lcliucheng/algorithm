package com.lc.algorithm.insert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liu cheng
 * @since 2020-04-17 12:35
 */
public class InsertDemo {
    /**
     * 57. 插入区间
     *
     * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
     * <p>
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     * <p>
     * 示例 1:
     * <p>
     * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出: [[1,5],[6,9]]
     * <p>
     * <p>
     * 示例 2:
     * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出: [[1,2],[3,10],[12,16]]
     * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ints = new ArrayList<> ();
        int min = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        boolean traget = false;
        boolean minTraget=true;
        boolean endTraget=false;
        for (int[] interval : intervals) {
            if (newInterval[0] <= interval[1]) {

                if (traget) {
                    ints.add (interval);
                    continue;
                }
                if(minTraget){
                    min = Math.min (newInterval[0], interval[0]);
                    minTraget=false;
                }

                if (newInterval[1] <= interval[1]&&!traget) {
                    if(interval[0]<=newInterval[1]){
                        max = Math.max (newInterval[1], interval[1]);
                    }else{
                        max=newInterval[1];
                        endTraget = true;
                    }

                    int[] aa = {min, max};
                    ints.add (aa);
                    traget = true;
                }
                if (endTraget) {
                    ints.add (interval);
                }

            } else {
                ints.add (interval);
            }
        }
        if (!traget) {
            if(min!=Integer.MIN_VALUE){
                max=newInterval[1];
                int []aa={min,max};
                ints.add (aa);
            }else{
                ints.add (newInterval);
            }

        }

        int[][] ints1 = ints.toArray (new int[0][0]);
        Arrays.sort (ints1, (v1, v2) -> v1[0] - v2[0]);
        return ints1;
    }

    public static void main(String[] args) {

        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
       //
        // int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 7};
        int[][] insert = insert (intervals, newInterval);
        for (int[] in : insert) {
            System.out.println (Arrays.toString (in));
        }
    }
}
