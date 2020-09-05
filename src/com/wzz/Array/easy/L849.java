package com.wzz.Array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
至少有一个空座位，且至少有一人坐在座位上。
亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
返回他到离他最近的人的最大距离。

示例 1：
输入：[1,0,0,0,1,0,1]
输出：2
解释：
如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
因此，他到离他最近的人的最大距离是 2 。

示例 2：
输入：[1,0,0,0]
输出：3
解释：
如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
这是可能的最大距离，所以答案是 3 。

提示：
2 <= seats.length <= 20000
seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximize-distance-to-closest-person
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L849 {
    public static void main(String[] args) {
        System.out.println(new L849().maxDistToClosest(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0}));
    }

    public int maxDistToClosest(int[] seats) {
        int haveOne = 0;//有1的个数 0 - 2
        int firstOne = 0;//第一次遇到的1的下标
        int countOne = 0;//数组中一共有几个1
        HashMap<Integer, Integer> map = new HashMap<>();//索引 距离

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1 && haveOne == 0) {//遇到的第一个 1
                firstOne = i;
                //离最数组头部的第一个1 也算入距离中
                map.put(i, firstOne - 0);
                haveOne++;
            } else if (seats[i] == 1 && haveOne == 1) {//遇到的第二个 1
                haveOne++;
                int mid = (i - firstOne) / 2 + firstOne;
                if (map.get(mid) != null) map.put(mid, Math.max(map.get(mid), Math.min(i - mid, mid - firstOne)));
                else map.put(mid, Math.min(i - mid, mid - firstOne));
                haveOne = 1;
                firstOne = i;//将当前第二个1 设置为第一个1 的位置
            }
            if (seats[i] == 1) countOne++;
        }
        //结束循环之后,最后一个1的位置是firstOne,也需要放入比较
        map.put(firstOne, seats.length - 1 - firstOne);
        Set<Integer> keySet = map.keySet();

        Integer[] toArray = keySet.toArray(new Integer[keySet.size()]);
        int rs = 0;

        for (int i = 0; i < toArray.length; i++) {
            rs = map.get(toArray[i]) > rs ? map.get(toArray[i]) : rs;
        }
        System.out.println(map);
        System.out.println(rs);
        //如果一共就数组中就一个1
        if (countOne == 1) return Math.max(seats.length - 1 - firstOne, firstOne - 0);

        return rs;
    }
}
