package com.wzz.writeExam.lanqiao.lanqiao_national_competition.nine;

/**
 * @Date 2020/11/11 15:04
 * @created by wzz
 * 已知三角形三个顶点在直角坐标系下的坐标分别为：
 * (2.3, 2.5)
 * (6.4, 3.1)
 * (5.1, 7.2)
 * <p>
 * 求该三角形的面积。
 * <p>
 * 注意，要提交的是一个小数形式表示的浮点数。
 * 要求精确到小数后3位，如不足3位，需要补零。
 */
public class _01 {
    //海伦公式 p = (a + b + c) / 2
    //area =  p * (p - a) * (p - b) * (p - c)
    public static void main(String[] args) {
        double a = Math.sqrt((6.4 - 2.3) * (6.4 - 2.3) + (3.1 - 2.5) * (3.1 - 2.5));
        double b = Math.sqrt((5.1 - 2.3) * (5.1 - 2.3) + (7.2 - 2.5) * (7.2 - 2.5));
        double c = Math.sqrt((6.4 - 5.1) * (6.4 - 5.1) + (7.2 - 3.1) * (7.2 - 3.1));
        double q = (a + b + c) / 2.0;
        double area = Math.sqrt(q * (q - a) * (q - b) * (q - c));
        System.out.println(area);
    }
}
