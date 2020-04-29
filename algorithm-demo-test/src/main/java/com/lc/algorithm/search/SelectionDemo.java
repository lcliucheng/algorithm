package com.lc.algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liu cheng
 * @since 2020-04-29 09:24
 */
public class SelectionDemo {
    /**
     * 面试题56 - I. 数组中数字出现的次数
     * 一个整型数组 nums 里除两个数字之外，.。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
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
     *
     * @return
     */

    public static int[] singleNumbers(int[] nums) {

        List<Integer> list = new ArrayList();
        List<Integer> ea = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            boolean ta = true;
            if(ea.contains(nums[i])){
                ta=false;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    ta = false;
                    ea.add(nums[i]);
                    break;
                }
            }

            if (ta) {
                list.add(nums[i]);
            }
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums={1,2,10,4,1,4,3,3};
        int[] ints = singleNumbers2(nums);
        System.out.println(Arrays.toString(ints));

    }
    public static int[] singleNumbers2(int[] nums) {
        //用于将所有的数异或起来
        int k = 0;

        for(int num: nums) {
            k ^= num;
        }

        //获得k中最低位的1
        int mask = 1;

        //mask = k & (-k) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
        while((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;

        for(int num: nums) {
            if((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }


}
