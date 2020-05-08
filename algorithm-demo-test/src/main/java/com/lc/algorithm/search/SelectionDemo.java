package com.lc.algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liu cheng
 * @since 2020-04-29 09:24
 */
public class SelectionDemo {
    /**
     * 面试题56 - I. 数组中数字出现的次数
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,1,4,6]
     * 输出：[1,6] 或 [6,1]
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,10,4,1,4,3,3]
     * 输出：[2,10] 或 [10,2]
     * <p>
     * <p>
     * 限制：
     * <p>
     * 2 <= nums <= 10000
     */

    public static int[] singleNumbers(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;

        // rightmost 1-bit diff between x and y
       int diff=4;

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums){
            if ((num & diff) != 0){
                x ^= num;
            }
        }

        return new int[]{x, bitmask ^ x};

    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<> ();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs (nums[i]) - 1;

            if (nums[index] < 0) {
                result.add (Math.abs (nums[i]));
                continue;
            }

            nums[index] = -nums[index];
        }

        return result;
    }

    public static void main(String[] args) {
       // System.out.println (findDuplicates (new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        int [] nums={4,1,4,5};
        System.out.println (Arrays.toString (singleNumbers(nums)));

        System.out.println (1&4);
        System.out.println (5&4);


    }
}
