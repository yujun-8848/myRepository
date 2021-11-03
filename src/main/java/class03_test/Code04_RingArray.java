package class03_test;

/**
 * @author yujun
 * @Description 循环数组，实现队列
 * @Date 2021/11/2
 */
public class Code04_RingArray {

    public static class MyQueue {
        private int size;
        private int pushi;
        private int popi;
        private final int limit;
        private final int[] arr;

        public MyQueue(int limit) {
            this.limit = limit;
            popi = 0;
            pushi = 0;
            size = 0;
            arr = new int[limit];
        }

        public void push(int value) {
            if (size == limit) {
                System.out.println("队列满了");
            }
            size++;
            arr[pushi] = value;
            //如果pushi 超过了limit
            pushi = pushi >= limit ? 0 : ++pushi;
        }

        public int pop() {
            if (size == 0) {
                System.out.println("队列为空");
            }
            size--;
            int ans = arr[popi];
            popi = popi >= limit ? 0 : ++popi;
            return ans;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(4);
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }

}
