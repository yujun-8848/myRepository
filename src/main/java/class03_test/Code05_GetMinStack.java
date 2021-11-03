package class03_test;

import java.util.Stack;

/**
 * @author yujun
 * @Description 实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
 * <p>
 * 1）pop、push、getMin操作的时间复杂度都是 O(1)。
 * <p>
 * 2）设计的栈类型可以使用现成的栈结构。
 * @Date 2021/11/3
 */
public class Code05_GetMinStack {


    public static class MyStack {
        private final Stack<Integer> stack;
        private final Stack<Integer> helper;

        public MyStack() {
            this.stack = new Stack<>();
            this.helper = new Stack<>();
        }

        public void pop() {
            if (stack.isEmpty()) {
                System.out.println("stack is null");
            }
            helper.pop();
            stack.pop();
        }

        public void push(int value) {

            stack.push(value);
            if (helper.isEmpty() || value < helper.peek()) {
                helper.push(value);
            } else
                helper.push(helper.peek());


        }

        public int getMin() {
            if (helper.isEmpty()) {
                System.out.println("stack is null");
            }
            return helper.peek();
        }

    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }


}
