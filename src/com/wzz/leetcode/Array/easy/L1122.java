package com.wzz.leetcode.Array.easy;

import java.util.HashMap;

/*
给你两个数组，arr1 和 arr2，
arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

示例：
输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
 
提示：
arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/relative-sort-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //存放arr1的每一个值出现的频数
        HashMap<Integer, Integer> map = new HashMap<>();
        //存放arr2的每一个值出现的频数
        HashMap<Integer, Integer> map2 = new HashMap<>();
        //正向计数
        int count = 0;
        //逆序计数
        int endCount = 0;
        //存放结果数组
        int[] rs = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (map.get(arr1[i]) != null) map.put(arr1[i], map.get(arr1[i]) + 1);
            else map.put(arr1[i], 1);
            if (i <= arr2.length - 1) map2.put(arr2[i], 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (map.get(arr2[i]) != null) {//出现在map中的数字
                for (int j = 0; j < map.get(arr2[i]); j++, count++) {
                    rs[count] = arr2[i];
                }
            }
        }
        int help = count;
        for (int i = 0; i < arr1.length; i++) {
            if (map2.get(arr1[i]) == null) {//未出现的数字
                rs[count] = arr1[i];
                count++;
            }
        }
        arrayStartIndex(help,rs);
        return rs;
    }

    private void arrayStartIndex(int help,int[] a) {
        for (int i = help; i < a.length; i++) {
            for (int j = help; j < a.length - 1; j++) {
                if (a[j] >= a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
