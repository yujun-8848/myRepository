package class01_test;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Code01_SelectionSort {

    public static void selectionSortTest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Arrays.sort(arr);
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0...N-1 中选出最小值  下标进行交换
        //1...N-1 中选出最小值  下标进行交换
        //2...N-1 中选出最小值  下标进行交换
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            //找出j...n-1下得最小值得下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //交换值
            swap(arr, i, minIndex);
        }
    }

    /**
     * arr中i位置和j位置数值交换位置
     * 必须保证i,j位置不同才能使用异或运算
     * 异或运算：不进位相加
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        //使用这种方式会存在问题
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
            selectionSort(copy1);
            selectionSortTest(copy2);
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
