package com.wzz.leetcode.array.easy;

/*
给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
完成所有替换操作后，请你返回这个数组。

示例：
输入：arr = [17,18,5,4,6,1]
输出：[18,6,6,6,1,-1]
 
提示：
1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1299 {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = getRightMax(arr, i + 1);
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    private int getRightMax(int[] arr, int i) {
        int max = 0;
        for (int j = i; j < arr.length; j++) {
            max = max > arr[j] ? max : arr[j];
        }
        return max;
    }
}
