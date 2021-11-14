package class06_test;

/**
 * @author yujun
 * @Description 大根堆
 * @Date 2021/11/14
 */
public class Code01_MyMaxHeap {

    public static class MyMaxHeap {

        //堆大小容量
        private final int limit;
        //实际值以heapSize大小为基准
        private int heapSize;
        private final int[] heap;

        public MyMaxHeap(int limit) {
            heapSize = 0;
            heap = new int[limit];
            this.limit = limit;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        public void push(int value) {
            if (isFull()) {
                System.out.println("heap is full");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize++);
        }

        public int pop() {
            //大根堆，即最大值在heap[0]位置
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapIfy(heap, 0, heapSize);
            return ans;
        }

        //至顶向下遍历比较
        //左孩子节点  left= 2 * i + 1;
        //右孩子节点  right= 2 * i + 2;
        private void heapIfy(int[] heap, int index, int heapSize) {
            //左孩子
            int left = 2 * index + 1;
            while (left < heapSize) {
                //右孩子可能有，可能没有，取出左右孩子中最大的下标
                int largest = left + 1 < heapSize && heap[left + 1] > heap[left] ?
                        left + 1 : left;
                largest = heap[largest] > heap[index] ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(heap, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }

        //heapInsert 节点由下至上遍历，比较大小
        //父节点位置 (i -1) / 2
        //如果子节点位置值大于父节点位置值，则交换值并继续向上比较
        public void heapInsert(int[] heap, int index) {
            while (heap[index] > heap[(index - 1) / 2]) {
                swap(heap, index, (index - 1) / 2);
                index = (index - 1) >> 1;
            }
        }

        public void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        MyMaxHeap heap = new MyMaxHeap(3);
        heap.push(3);
        heap.push(5);
        heap.push(2);
        System.out.println(heap.pop());

    }
}
