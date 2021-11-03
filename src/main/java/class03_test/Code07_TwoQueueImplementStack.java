package class03_test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yujun
 * @Description 使用队列来实现栈
 * @Date 2021/11/3
 */
public class Code07_TwoQueueImplementStack {

    public static class TwoQueueStack {
        private Queue<Integer> queue;
        private Queue<Integer> helper;

        public TwoQueueStack() {
            queue = new LinkedList();
            helper = new LinkedList();
        }

        public void push(int value) {
            queue.offer(value);
        }

        public int pop() {
            //保留队列中最后一个值，弹出即为栈中的第一个值
            while (queue.size() > 1) {
                helper.offer(queue.poll());
            }
            //弹出
            int ans = queue.poll();
            //交换引用
            Queue<Integer> temp = helper;
            helper = queue;
            queue = temp;
            return ans;
        }

        public int peek() {
            while (queue.size() > 1) {
                helper.offer(queue.poll());
            }
            int ans = queue.poll();
            helper.offer(ans);
            Queue<Integer> temp = helper;
            helper = queue;
            queue = temp;
            return ans;
        }
    }

    public static void main(String[] args) {
        TwoQueueStack stack = new TwoQueueStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
