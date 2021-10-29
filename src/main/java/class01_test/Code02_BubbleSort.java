package class01_test;

import java.util.Arrays;

/**
 * @author yujun
 * @Description 冒泡排序
 * @Date 2021/10/29
 */
public class Code02_BubbleSort {

    public static void bubbleSortTest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Arrays.sort(arr);
    }
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }

        }

    }

    /**
     * 异或运算交换值
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    //编写对数器
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
        }
        return arr;
    }

    public static int[] copy(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {

        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 != null && arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;

    }

    public static void test() {
        System.out.println("开始测试");
        int testTime = 1000;
        int maxSize = 100;
        int maxValue = 100;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] copy1 = copy(arr);
            int[] copy2 = copy(arr);
            bubbleSort(copy1);
            bubbleSortTest(copy2);
            if (!isEqual(copy1, copy2)) {
                System.out.println("源数组" + Arrays.toString(arr));
                break;
            }
        }
        System.out.println("结束测试");


    }

    public static void main(String[] args) {
        test();
    }

}
