package class05_test;

import java.util.Arrays;

/**
 * @author yujun
 * @Description 快速排序和荷兰国旗问题
 * @Date 2021/11/9
 */
public class Code02_PartitionAndQuickSort {
    //数组中两数进行交换
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int less = L - 1;
        int index = L;
        while (index <= R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index++, ++less);
            } else {
                index++;
            }
        }
        swap(arr, ++less, R);
        return less;
    }

    // arr[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值
    // <arr[R] ==arr[R] > arr[R]
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};

    }

    //快排2.0
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    //快排3.0 随机快排
    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    //递归定义:arr[L..R]中排有序
    public static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int) ((R - L + 1) * Math.random()), R);
        int[] ans = netherlandsFlag(arr, L, R);
        int left = ans[0] - 1;
        int right = ans[1] + 1;
        process3(arr, L, left);
        process3(arr, right, R);
    }

    //递归定义:arr[L..R]中排有序
    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] ans = netherlandsFlag(arr, L, R);
        int left = ans[0] - 1;
        int right = ans[1] + 1;
        process(arr, L, left);
        process(arr, right, R);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 5, 7, 3, 2};
        quickSort3(arr);
        System.out.println(Arrays.toString(arr));
    }

}
