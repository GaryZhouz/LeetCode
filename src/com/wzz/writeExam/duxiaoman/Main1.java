package com.wzz.writeExam.duxiaoman;

import java.util.*;

/*
小明发现有的字符串中蕴含着一些规律，但是它们又和普通的周期串有点不一样。
例如：ABCABDABDABE。
如果以3为周期，可以看到其中包含“ABC”、“ABD”和“ABE”等子串，其中“ABD”出现了两次。
这些子串两两之间最多只有某一位上的字符不相同，
其他位置上的字符都一样。小明将其称为“近似串”，
由多个“近似串”组成的字符串称为“近似周期串”。
“近似周期串”中的每一个“近似串”的长度需大于等于2。

需要注意的是“ABCABBACD”并不是一个“近似周期串”。
如果以3为周期，其子串包括“ABC”、“ABB”和“ACD”，
“ABB”与“ACD”、“ABC”与“ACD”均存在两个位置上的字符不相同，
因此不是“近似周期串”。特别的，“AAAAAA”也是一个“近似周期串”，
因为它满足上述“近似周期串”的定义。

现在给你一个字符串，请编写一个程序判断该字符串是否是以3为周期的“近似周期串”。

输入描述

多组输入，第1行输入一个正整数T表示输入数据的组数。
对于每一组输入数据：输入一个长度不超过1000的字符串，字符串中只包含大写英文字母。

输出描述
针对每一组输入数据，输出该字符串是否是以3为周期的“近似周期串”，如果是输出“Yes”，否则输出“No”。

样例输入
2
ABCABDABDABEABEABF
ABCABDAEC
样例输出
Yes
No
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String[] strings = new String[i];
        for (int j = 0; j < i; j++) {
            strings[j] = scanner.next();
        }
        for (int j = 0; j < strings.length; j++) {
            System.out.println(handle(strings[j]));
        }
    }

    private static String handle(String string) {
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 3; i < string.length(); i += 3) {
            set.add(string.substring(i - 3, i));
        }

        set.add(string.substring(string.length() - 3));
        String s = set.toString().trim().replace("[", "").replace("]", "").replaceAll(" ", "").replaceAll(",", "");


        for (int i = 3; i < s.length(); i += 3) {
            list.add(s.substring(i - 3, i));
        }

        list.add(s.substring(s.length() - 3));

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (!check(list.get(i), list.get(j))) return "No";
            }
        }
        return "Yes";
    }

    private static boolean check(String i, String x) {
        int count = 0;
        for (int j = 0; j < i.length(); j++) {
            if (i.charAt(j) == x.charAt(j)) count++;
        }
        return count >= 2;
    }
}
