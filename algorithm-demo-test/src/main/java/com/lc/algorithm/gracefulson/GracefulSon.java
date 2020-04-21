package com.lc.algorithm.gracefulson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liu cheng
 * @since 2020-04-21 13:54
 */
public class GracefulSon {
    /**
     * 1248. 统计「优美子数组」
     * <p>
     * 给你一个整数数组 nums 和一个整数 k。
     * <p>
     * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
     * <p>
     * 请返回这个数组中「优美子数组」的数目。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2,1,1], k = 3
     * 输出：2
     * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
     * 示例 2：
     * <p>
     * 输入：nums = [2,4,6], k = 1
     * 输出：0
     * 解释：数列中不包含任何奇数，所以不存在优美子数组。
     * 示例 3：
     * <p>
     * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
     * 输出：16
     */

    public static int numberOfSubarrays(int[] nums, int k) {
        // sum是前缀和
        int sum = 0;
        int res = 0;
        // map的键是前缀和  map的值是前缀和出现的次数
        HashMap<Integer, Integer> map = new HashMap<> ();
        // 前缀和为0 出现的次数是1次
        map.put (0, 1);
        for (int num : nums) {
            sum += (num & 1);
            /*当前前缀和是sum，尝试在map中查找 是否存在键值是sum-k(即前缀和是sum-k) ，若找到，即找到子序列和是k*/
            if (map.containsKey (sum - k)) {
                res += map.get (sum - k);
            }
            map.put (sum, map.getOrDefault (sum, 0) + 1);
        }
        return res;
    }


    public static int numberOfSubarrays2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        // 双指针
        int left = 0, right = 0;
        int count = 0; // 连续子数组中奇数的个数
        int res = 0;
        int preEven = 0; // 记录第一个奇数前面的偶数个数
        while (right < nums.length) {
            // 连续子数组中奇数个数不够
            if (count < k) {
                if (nums[right] % 2 != 0) count++;
                right++; // 移动右侧指针
            }
            // 连续子数组中奇数个数够了，看第一个奇数前面有多少个偶数
            if (count == k) {
                preEven = 0;
                while (count == k) {
                    res++;
                    if (nums[left] % 2 != 0) count--;
                    left++;
                    preEven++;
                }
            } else res += preEven; // 每次遇到 right 为偶数的时候就进行累加 相当于区间前面偶数个数 * 后面偶数个数
        }
        return res;
    }

    public int numberOfSubarrays3(int[] nums, int k) {
        int preEven = 0;
        List<Integer> list = new ArrayList<> ();
        for (int i : nums) {
            if ((i & 1) == 0) {
                preEven++;
            } else {
                list.add (preEven + 1);
                preEven = 0;
            }
        }
        list.add (preEven + 1);
        // list.forEach(o-> System.out.println(o));
        int count = 0;
        for (int i = 0; i < list.size () - k; i++) {
            count += (list.get (i) * list.get (i + k));
        }
        return count;
    }

    public static int numberOfSubarrays4(int[] nums, int k) {
        int count = 0;
        int res=0;
        int h=0;
        ArrayList<Integer> index = new ArrayList<> ();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                index.add (i);
                count++;
            }
            if (count == k) {
                int pre=0;
                for (int j = (i+1); j < nums.length; j++) {
                   if(nums[j]%2==0){
                       pre++;
                   }else{
                       break;
                   }
                }
                Integer integer = index.get (h);
                int before;
                if(h==0){
                    before=integer-0;
                }else{
                    Integer integer1 = index.get (h - 1);
                    before=integer-integer1-1;
                }
                res+=1+pre+before;
                res+=pre*before;
                h++;
                count--;
            }
        }
        return res;

    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1,2, 1, 1};
        int[] numse = {2,3, 4, 6};
        int[] aa = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2,1};
        int []bb={91473,45388,24720,35841,29648,77363,86290,58032,53752,87188,34428,85343,19801,73201};
        int k =1;
        int i = numberOfSubarrays4(nums, k);
        System.out.println (i);
    }


}
