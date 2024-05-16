package com.wzz.leetcode.array.easy;

import java.util.*;

/**
 * @Date 2021/7/24 10:16
 * @created by wzz
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class L350 {

    public int[] intersect(int[] nums1, int[] nums2) {
//        Map<Integer, Integer> map1 = new HashMap<>();
//        Map<Integer, Integer> map2 = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
//        toHash(nums1, map1);
//        toHash(nums2, map2);
//        for (Integer key : map1.keySet()) {
//            if (map2.containsKey(key)) {
//                for (int i = 0; i < Math.min(map1.get(key), map2.get(key)); i++) {
//                    list.add(key);
//                }
//            }
//        }
//        int[] result = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            result[i] = list.get(i);
//        }
//        return result;
        int left1 = 0, left2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        while (left1 <= nums1.length - 1 && left2 <= nums2.length - 1) {
            if (nums1[left1] == nums2[left2]) {
                list.add(nums1[left1]);
                left1++;
                left2++;
            } else if (nums1[left1] > nums2[left2]) {
                left2++;
            } else {
                left1++;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void toHash(int[] nums1, Map<Integer, Integer> map1) {
        for (int value : nums1) {
            if (map1.containsKey(value)) {
                map1.put(value, map1.get(value) + 1);
            } else {
                map1.put(value, 1);
            }
        }
    }
}
