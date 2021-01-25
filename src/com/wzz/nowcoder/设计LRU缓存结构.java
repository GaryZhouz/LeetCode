package com.wzz.nowcoder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Date 2021/1/25 10:09
 * @created by wzz
 */
public class 设计LRU缓存结构 {
    /**
     * lru design
     * <p>
     * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
     * set(key, value)：将记录(key, value)插入该结构
     * get(key)：返回key对应的value值
     * [要求]
     * set和get方法的时间复杂度为O(1)
     * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
     * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
     * 若opt=1，接下来两个整数x, y，表示set(x, y)
     * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
     * 对于每个操作2，输出一个答案
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        // true 表示让 linkedHashMap 按照访问顺序来进行排序，最近访问的放在尾部，最老访问的放在头部。
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>((int) Math.ceil(k / 0.75) + 1, 0.75f, true);
        // 存储结果的集合
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {// set操作
                if (map.size() >= k) {// 如果大小大于了
                    map.remove(map.keySet().iterator().next());
                }
                map.put(operators[i][1], operators[i][2]);
            } else {// 2 get操作
                if (map.get(operators[i][1]) == null) {
                    list.add(-1);
                } else {
                    list.add(map.get(operators[i][1]));
                }
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int i : list) {
            res[index++] = i;
        }
        return res;
    }
}
