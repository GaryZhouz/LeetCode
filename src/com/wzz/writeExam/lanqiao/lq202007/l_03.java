package com.wzz.writeExam.lanqiao.lq202007;

/*
新冠疫情由新冠病毒引起，最近在 A 国蔓延，为了尽快控制疫情， A 国准
备给大量民众进病毒核酸检测。
然而，用于检测的试剂盒紧缺。
为了解决这一困难，科学家想了一个办法：合并检测。即将从多个人（k
个）采集的标本放到同一个试剂盒中进行检测。如果结果为阴性，则说明这 k
个人都是阴性，用一个试剂盒完成了 k 个人的检测。如果结果为阳性，则说明
至少有一个人为阳性，需要将这 k 个人的样本全部重新独立检测（从理论上看，
如果检测前 k − 1 个人都是阴性可以推断出第 k 个人是阳性，但是在实际操作中
不会利用此推断，而是将 k 个人独立检测），加上最开始的合并检测，一共使用
了 k + 1 个试剂盒完成了 k 个人的检测。
A 国估计被测的民众的感染率大概是 1%，呈均匀分布。请问 k 取多少能
最节省试剂盒？
 */
public class l_03 {
    public static void main(String[] args) {
        int people = 1000;
        int min = Integer.MAX_VALUE;
        //结果
        int res = 0;
        //试剂使用量
        int count = 0;
        //i => 一组的人数
        for (int i = 1; i <= people; i++) {
            if (people % i == 0) {
                count = people / i + (int) (people * 0.01 * i);
            } else {
                count = people / i + (int) (people * 0.01 * i) + 1;
            }
            if (count < min) {
                min = count;
                res = i;
            }
        }
        System.out.println(res);
    }
}
