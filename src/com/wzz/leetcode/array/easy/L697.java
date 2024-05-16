package com.wzz.leetcode.array.easy;

import java.util.HashMap;

/*
给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

示例 1:
输入: [1, 2, 2, 3, 1]
输出: 2
解释:
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.

示例 2:
输入: [1,2,2,3,1,4,2]
输出: 6
注意:
nums.length 在1到50,000区间范围内。
nums[i] 是一个在0到49,999范围内的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/degree-of-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L697 {
    public static void main(String[] args) {
        System.out.println(new L697().findShortestSubArray(new int[]{2, 1}));
    }

    public int findShortestSubArray(int[] nums) {
        if (nums.length==1) return 1;
        else if (nums.length==0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;//出现的频数最高
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
                max = Math.max(map.get(nums[i]), max);
            }
            else {
                map.put(nums[i], map.get(nums[i]) + 1);
                max = Math.max(map.get(nums[i]), max);
            }
        }
        Integer[] map_key = map.keySet().toArray(new Integer[map.keySet().size()]);
        int min_res = Integer.MAX_VALUE;//结果中取最小的
        for (int i = 0; i < map_key.length; i++) {
            if (map.get(map_key[i]) == max) {//当前数字为频数最大的那个数字
                min_res = Math.min(getLength(map_key[i], nums), min_res);
            }
        }
        return min_res;
    }

    private int getLength(Integer integer, int[] nums) {
        int firstFind = 0;
        int endFind = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == integer) {
                firstFind = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == integer) {
                endFind = i;
                break;
            }
        }
        return endFind - firstFind + 1;
    }
}
