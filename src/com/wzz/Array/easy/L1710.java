package com.wzz.Array.easy;

import java.util.HashMap;

/*
数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。

示例 1：
输入：[1,2,5,9,5,9,5,5,5]
输出：5
 
示例 2：
输入：[3,2]
输出：-1
 

示例 3：
输入：[2,2,1,1,1,2,2]
输出：2
 
说明：
你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-majority-element-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1710 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        //出现次数放入map中
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null)
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i])+1);
        }

        //查找map中是否有次数大于长度一半的
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
}
