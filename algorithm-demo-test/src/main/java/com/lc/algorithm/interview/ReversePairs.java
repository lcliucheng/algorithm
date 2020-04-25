package com.lc.algorithm.interview;

import java.util.Arrays;

/**
 * @author liu cheng
 * @since 2020-04-24 14:55
 */
public class ReversePairs {

    /**
     *
     * 面试题51. 数组中的逆序对
     *
     在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

     示例 1:

     输入: [7,5,6,4]
     输出: 5
      

     限制：

     0 <= 数组长度 <= 50000

     */


    public static int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs (copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     *
     */
    private static int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs (nums, left, mid, temp);
        int rightPairs = reversePairs (nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount (nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }

    // 7-5  1
    //6-4   1
    //5 7 4 6
    //5-4   1
    //7-6   1
    public static void main(String[] args) throws Exception {
        int[] nums = {7, 5, 6, 4};
        int i = reversePairs2 (nums);
        System.out.println (Arrays.toString (nums));
        System.out.println ("个数：" + i);
    }

    public static int reversePairs2(int[] nums) {
        int[] temp = new int[nums.length];

        return sort (nums, 0, nums.length - 1, temp);
    }

    public static int sort(int[] nums, int left, int right, int[] tmep) {
        if (left < right) {
            int mid = (right + left) / 2;
            int leftCount = sort (nums, left, mid, tmep);
            int rightCount = sort (nums, mid + 1, right, tmep);
            return leftCount + rightCount + merge (nums, left, mid, right, tmep);
        }
        return 0;

    }


    public static int merge(int[] nums, int left, int mid, int right, int[] tmep) {
        int count = 0;
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmep[t++] = nums[i];
                i++;
            } else {
                //这句的意思，我把小一点的数据，从右边移动左边的位置i的时候，
                // 记录右边这个移动的数据，与左边序列组成逆序对的个数，
                count += (mid - i + 1);
                tmep[t++] = nums[j];
                j++;


            }
        }
        while (i <= mid) {
            tmep[t++] = nums[i];
            i++;

        }

        while (j <= right) {

            tmep[t++] = nums[j];
            j++;

        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            nums[left++] = tmep[t++];
        }
        return count;
    }


    public static int reversePairs3(int[] nums) {
        return merge (nums, 0, nums.length - 1);
    }

    static int merge(int[] arr, int start, int end) {
        if (start == end) return 0;
        int mid = (start + end) / 2;
        int count = merge (arr, start, mid) + merge (arr, mid + 1, end);

        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            count += arr[i] <= arr[j] ? j - (mid + 1) : 0;
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            count += j - (mid + 1);
            temp[k++] = arr[i++];
        }
        while (j <= end)
            temp[k++] = arr[j++];
        System.arraycopy (temp, 0, arr, start, end - start + 1);
        return count;
    }


}
