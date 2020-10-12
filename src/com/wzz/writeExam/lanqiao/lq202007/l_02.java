package com.wzz.writeExam.lanqiao.lq202007;

import java.util.Date;
/*
2020 年 7 月 1 日是中国共产党成立 99 周年纪念日。
中国共产党成立于 1921 年 7 月 23 日。
请问从 1921 年 7 月 23 日中午 12 时到 2020 年 7 月 1 日中午 12 时一共包
含多少分钟？

52038720
 */
public class l_02 {
    public static void main(String[] args) {
        Date d1 = new Date("1921/07/23");
        Date d2 = new Date("2020/07/01");
        long time1 = d1.getTime();
        long time2 = d2.getTime();
        long l = (time2 - time1) / 1000 / 60;
        System.out.println(l);
    }
}
