package com.wzz.leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你个整数数组 arr，其中每个元素都 不相同。
请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。

示例 1：
输入：arr = [4,2,1,3]
输出：[[1,2],[2,3],[3,4]]

示例 2：
输入：arr = [1,3,6,10,15]
输出：[[1,3]]

示例 3：
输入：arr = [3,8,-10,23,19,-4,-14,27]
输出：[[-14,-10],[19,23],[23,27]]

提示：
2 <= arr.length <= 10^5
-10^6 <= arr[i] <= 10^6
 */
public class L1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        //标记当前最小绝对差
        int minTemp = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i=0; i < arr.length-1; i++){
            int curMinimum = arr[i+1] - arr[i];

            //有更小的绝对差，清空
            if(curMinimum < minTemp){
                ans.clear();
                minTemp = curMinimum;
            }

            if(curMinimum == minTemp){
                List<Integer> res = new ArrayList<>();
                res.add(arr[i]);
                res.add(arr[i+1]);
                ans.add(res);
            }
        }
        return ans;
    }
}
