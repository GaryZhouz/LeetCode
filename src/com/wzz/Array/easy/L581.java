package com.wzz.Array.easy;

import java.util.Arrays;

/*
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
你找到的子数组应是最短的，请输出它的长度。

示例 1:
输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
说明 :
输入的数组长度范围在 [1, 10,000]。
输入的数组可能包含重复元素 ，所以升序的意思是<=。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        Arrays.sort(copy);
        int start = 0;//对排序后的数组与原数组对比 第一个不一致的地方
        int end = 0;//对排序后的数组与原数组对比 最后一个不一致的地方
        for (int i = 0; i < nums.length; i++) {
            if (copy[i] != nums[i]) {
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (copy[i] != nums[i]) {
                end = i;
                break;
            }
        }
        if (end == start) return 0;
        return end - start + 1;
    }
}
