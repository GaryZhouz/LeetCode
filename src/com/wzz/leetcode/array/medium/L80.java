package com.wzz.leetcode.array.medium;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 */
public class L80 {
    public static int removeDuplicates(int[] nums) {
        int point1 = 0;
        int point2 = 1;
        int repeatCount = 0;
        while (point1 < nums.length - repeatCount && point2 < nums.length - repeatCount) {
            if ((nums[point1] != nums[point2] || point2 == nums.length - 1 - repeatCount) && point2 - point1 >= 2) {
                // 需要替换的个数(如果是一直没有相同的导致point2走到尽头 这个时候得判断是否到底有重复的超过2个的 其实就是最后一个和第一个相不相等)
                int segment = point2 - point1 - (point2 == nums.length - 1 - repeatCount && nums[point1] == nums[point2] ? 1 : 2);
                // 开始移动的索引
                int needSwapStart = point1 + 2;
                while (needSwapStart < nums.length - segment) {
                    nums[needSwapStart] = nums[needSwapStart + segment];
                    needSwapStart++;
                }
                repeatCount += segment;
            }
            if (nums[point1] == nums[point2]) {
                point2++;
            } else {
                point1++;
                point2 = point1 + 1;
            }
        }
        return nums.length - repeatCount;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,1,2,2,2,2,2,3,4,4,4}));
    }
}
