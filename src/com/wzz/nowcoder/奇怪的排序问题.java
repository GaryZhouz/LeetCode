package com.wzz.nowcoder;

/**
 * @Date 2021/2/6 10:07
 * @created by wzz
 */
public class 奇怪的排序问题 {
    /**
     * 题目描述
     * 现在给出数n和一个1到n的数组，求最少的选择次数，使数组变为升序。
     * <p>
     * 示例1
     * 输入
     * 复制
     * 4,[4,1,2,3]
     * 返回值
     * 复制
     * 1
     * 备注:
     * n<=10^6
     * 数据包含一个整数n和一个含有n个元素的数组，表示从队头到队尾的人的身高。
     * 输出一个整数表示答案。
     * <p>
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n int整型
     * @param a int整型一维数组
     * @return int整型
     */
    public int wwork(int n, int[] a) {
        int min = a[n - 1];
        int num = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > min) {
                num++;
            } else {
                min = a[i];
            }
        }
        return num;
    }
}
