package com.wzz.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/6/9 20:23
 * @created by wzz
 * 给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *  
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 * 输入：nums = []
 * 输出：[]
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：["-1"]
 * 示例 5：
 * 输入：nums = [0]
 * 输出：["0"]
 * <p>
 * 提示：
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L228 {
    public List<String> summaryRanges(int[] nums) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {// 连续
                if (sb.length() == 0) {
                    sb.append(nums[i - 1])
                            .append("->");
                }
            } else {// 不连续了
                sb.append(nums[i - 1]);
                result.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        if (nums.length > 0) {
            result.add(sb.append(nums[nums.length - 1]).toString());
        }
        return result;
    }
}
