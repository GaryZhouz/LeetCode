package com.wzz.writeExam.jinshanyun;

import java.util.Arrays;
import java.util.Scanner;

/*
首先按照从上到下、从左到右的顺序输入一棵满二叉树中每一个结点对应的权重，
例如输入1、1、2表示二叉树的根结点的权重为1，它的左、右两个子节点的权重分别为1和2。

然后判断该满二叉树中是否存在这样的非叶子结点：
它的左子树上所有结点的权重之和等于右子树上所有结点的权重之和。
现在给你一棵满二叉树的所有结点的权重，请编写一个程序，
寻找是否存在满足要求的非叶子结点，如果存在输出“Yes”，否则输出“No”。



输入描述
多组输入。

第1行输入一个正整数T表示测试数据的数量。(T<=100)

接下来T行对应T组输入，每组输入数据占一行，该行包含n个正整数（n满足2^k-1），两两之间用空格隔开，1<n<=1000。

输出描述
对于每组输入数据，如果能够找到满足要求的非叶子结点（左子树上所有结点的权重之和等于右子树上所有结点的权重之和），输出“Yes”，否则输出“No”。


样例输入
3
1 2 2 1 2 1 2
1 2 2 1 3 2 2
1 2 2 1 2 1 3
样例输出
Yes
Yes
No
 */
public class Main {
    static int leftSum = 0;
    static int rightSum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String[] strings = new String[i + 1];
        for (int j = 0; j < i + 1; j++) {
            strings[j] = scanner.nextLine();
        }
        String[] s = strings[2].split(" ");
        leftTree(s);
        System.out.println(leftSum);
        System.out.println(rightSum);
    }

    private static void leftTree(String[] string) {
        leftSum += Integer.parseInt(string[0]);
        rightSum += Integer.parseInt(string[0]);
        for (int i = 0; i < string.length; i++) {
            if (2 * i + 1 < string.length)
                leftSum += Integer.parseInt(string[2 * i + 1]);
            else if (2 * i + 2 < string.length && i > 1)
                leftSum += Integer.parseInt(string[2 * i + 2]);
            else rightSum += Integer.parseInt(string[i]);
        }
    }
}
