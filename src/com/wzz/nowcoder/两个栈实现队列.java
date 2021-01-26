package com.wzz.nowcoder;

import java.util.Stack;

/**
 * @Date 2021/1/26 15:37
 * @created by wzz
 */
public class 两个栈实现队列 {
    // 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        stack2.clear();
        // 将栈1的值 反向压入 栈2
        for (int i = stack1.size() - 1; i >= 0; i--) {
            stack2.push(stack1.get(i));
        }
    }

    public int pop() {
        // 栈1移除最底层的元素(相当于队列出队了)
        stack1.remove(0);
        return stack2.pop();
    }

    public static void main(String[] args) {
        两个栈实现队列 er = new 两个栈实现队列();
        er.push(1);
        er.push(2);
    }
}
