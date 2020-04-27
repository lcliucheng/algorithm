package com.lc.algorithm.array;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * @author liu cheng
 * @since 2020-04-26 13:49
 */

public class PermuteDemo {
    /**
     * 46. 全排列
     * <p>
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     * <p>
     * [ij]
     */

    public static List<List<Integer>> permute(int[] nums) {


        LinkedBlockingQueue<int[]> lists = new LinkedBlockingQueue<> ();
        int[] temp = Arrays.copyOf (nums, nums.length);
        lists.add (temp);
        List<List<Integer>> os = new ArrayList<> ();


        for (int first = 0; first < nums.length; first++) {
            LinkedBlockingQueue<int[]> newLists = new LinkedBlockingQueue<> ();
            while (!lists.isEmpty ()) {
                int[] poll = lists.poll ();
                for (int i = first; i < poll.length; i++) {
                    int[] ints = Arrays.copyOf (poll, poll.length);
                    int fi = ints[first];
                    ints[first] = ints[i];
                    ints[i] =fi;
                    newLists.add (ints);
                }
            }
            lists=newLists;

        }
       while (!lists.isEmpty ()){
           int[] poll = lists.poll ();
           os.add (toList (poll));
       }


        return os;
    }

    private static List<Integer> toList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<> ();
        for (int i : nums) {
            list.add (i);
        }
        return list;
    }

    public static void backtrack(int n,
                          ArrayList<Integer> output,
                          List<List<Integer>> res,
                          int first) {
        // 所有数都填完了
        if (first == n)
            res.add(new ArrayList<Integer>(output));
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new LinkedList();

        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add (num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }



    public static void main(String[] args) {
        int [] nums={1,2,3};
        System.out.println (permute2( nums));
    }

}
