package class03_test;

import java.util.Stack;

/**
 * @author yujun
 * @Description 使用双栈实现队列
 * @Date 2021/11/3
 */
public class Code06_TwoStacksImplementQueue {


    public static class TwoStacksQueue {
        //push栈
        private final Stack<Integer> push;
        //pop栈
        private final Stack<Integer> pop;

        public TwoStacksQueue() {
            this.push = new Stack<>();
            this.pop = new Stack<>();
        }

        //为了保证栈中的数据按照队列的顺序出列
        //必须将push栈中的值导到pop栈中
        public  void pushToPop() {
            //必须保证pop栈为空才导入
            if(pop.isEmpty()){
                while (!push.isEmpty()){
                    pop.push(push.pop());
                }
            }

        }

        public void push(int value) {
            push.push(value);
            pushToPop();

        }

        public int pop() {
            if(pop.isEmpty() && push.isEmpty()){
                System.out.println("queue is null");
            }
            pushToPop();
            return pop.pop();

        }

    }

    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(5);
        queue.push(6);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
