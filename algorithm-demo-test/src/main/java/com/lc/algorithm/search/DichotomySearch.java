package com.lc.algorithm.search;

/**
 * @author liu cheng
 * @since 2020-04-27 13:50
 */

public class DichotomySearch {

    /**
     * 33. 搜索旋转排序数组
     *
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 示例 1:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     *
     */
    public static int search(int[] nums, int target) {
        int a=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                a=i;
                break;
            }
        }
        return a;
    }

    public static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;

    }

    public static int search3(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = start + (end -start)/2;
            if (nums[mid] == target){
                return mid;
            }

            //后半部分有序
            if(nums[mid] < nums[end]){
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            } else {
                if(nums[mid] > target && target >= nums[start]){
                    end = mid - 1;

                } else {
                    start = mid + 1;

                }


            }
        }
        return -1;

    }

    public static int search4(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {

            int mid = left + (right - left  + 1) / 2;

            if (nums[mid] < nums[right]) {

                // 使用上取整的中间数，必须在上面的 mid 表达式的括号里 + 1
                if (nums[mid] <= target && target <= nums[right]) {
                    // 下一轮搜索区间是 [mid, right]
                    left = mid;
                } else {
                    // 只要上面对了，这个区间是上面区间的反面区间，下一轮搜索区间是 [left, mid - 1]
                    right = mid - 1;
                }

            } else {

                // [left, mid] 有序，但是为了和上一个 if 有同样的收缩行为，
                // 我们故意只认为 [left, mid - 1] 有序
                // 当区间只有 2 个元素的时候 int mid = (left + right + 1) >>> 1; 一定会取到右边
                // 此时 mid - 1 不会越界，就是这么刚刚好

                if (nums[left] <= target && target <= nums[mid - 1]) {
                    // 下一轮搜索区间是 [left, mid - 1]
                    right = mid - 1;
                } else {
                    // 下一轮搜索区间是 [mid, right]
                    left = mid;
                }
            }
        }

        // 有可能区间内不存在目标元素，因此还需做一次判断
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }





    public static void main(String[] args) {
        int[] nums={1,2,6,5,4,3};
        int[] nums2={1,2,3,4,5,6};
        int[] nums3={4,5,6,1,2,3};
        int search = search4(nums3, 2);
        System.out.println (search);
    }




}
