package com.wzz.leetcode.array.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 * <p>
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 * <p>
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
public class L414 {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = set.stream()
                .sorted()
                .collect(Collectors.toList());
        if (list.size() <= 2) {
            return list.get(list.size() - 1);
        }
        return list.get(list.size()-3);
    }
}
