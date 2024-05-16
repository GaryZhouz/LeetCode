package com.wzz.leetcode.array.easy;

import java.util.HashSet;
import java.util.Set;

/*
给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
请你找到这个数组里第 k 个缺失的正整数。

示例 1：
输入：arr = [2,3,4,7,11], k = 5
输出：9
解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。

示例 2：
输入：arr = [1,2,3,4], k = 2
输出：6
解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。

提示：
1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j] 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-missing-positive-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1539 {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int max = arr[arr.length - 1] + k;//当前数组中最大的数字 需要加k 防止数字连续 以便于能有后面的值
        int count = 0;//帮助计数第几个缺失的值
        for (int i = 1; i <= max; i++) {
            if (!set.contains(i)){
                count++;
                if (count == k) return i;
            }
        }
        return 1;
    }
}
