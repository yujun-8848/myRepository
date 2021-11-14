package class06_test;

/**
 * @author yujun
 * @Description 堆排序
 * @Date 2021/11/14
 */
public class Code02_HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapIfy(arr, i, arr.length);
        }
        int heapSize = arr.length;
        while (heapSize > 0) {
            heapInsert(arr, 0);
            heapSize--;
        }
    }

    private static void heapIfy(int[] heap, int index, int heapSize) {

    }

    private static void heapInsert(int[] heap, int index) {

    }

}
