package class04_test;

import java.util.Arrays;

/**
 * @author yujun
 * @Description 归并排序
 * 通过归并排序了解递归过程
 * 熟悉整个递归流程,QAQ,加油
 * @Date 2021/11/4
 */
public class Code01_MergeSort {

    public static void test(int[] arr) {
        Arrays.sort(arr);
    }

    //递归版归并排序
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //整个数组排有序
        process(arr, 0, arr.length - 1);
    }

    //递归定义:arr[L...R]中排有序
    private static void process(int[] arr, int L, int R) {
        //base case
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        //左边有序
        process(arr, L, mid);
        //右边有序
        process(arr, mid + 1, R);
        //merge有序
        mergeSort(arr, L, mid, R);
    }

    //merge过程:将左边有序的数组和右边有序的数组进行排序
    private static void mergeSort(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int p = 0;
        int left = L;
        int right = mid + 1;
        while (left <= mid && right <= R) {
            help[p++] = arr[left] <= arr[right] ? arr[left++] : arr[right++];
        }
        while (left <= mid) {
            help[p++] = arr[left++];
        }
        while (right <= R) {
            help[p++] = arr[right++];
        }
        if (help.length >= 0)
            System.arraycopy(help, 0, arr, L, help.length);

    }

    //对数器用于测试
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
        }
        return arr;

    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
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

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int testTime = 10000;
        int maxSize = 10;
        int maxValue = 10;
        for (int i = 0; i < testTime; i++) {
            int[] array = generateRandomArray(maxSize, maxValue);
            int[] array1 = copyArray(array);
            mergeSort1(array);
            test(array1);
            if (!isEqual(array, array1)) {
                System.out.println("失败");
                System.out.println(Arrays.toString(array));
                System.out.println(Arrays.toString(array1));
                break;
            }

        }
    }
}
