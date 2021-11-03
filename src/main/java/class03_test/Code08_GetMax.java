package class03_test;

import java.util.Arrays;

/**
 * @author yujun
 * @Description 使用递归求解数组中的最大值
 * @Date 2021/11/3
 */
public class Code08_GetMax {

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int getMax_test(int[] arr) {
        Arrays.sort(arr);

        return arr[arr.length - 1];
    }

    //递归定义：arr[L...R]中的最大值
    public static int process(int[] arr, int L, int R) {
        // base case
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int left = process(arr, L, mid);
        int right = process(arr, mid + 1, R);
        return Math.max(left, right);
    }

    //编写对数器
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
//        int testTime = 10000;
//        int maxSize = 10;
//        int maxValue = 10;
//        System.out.println("start--");
//        for (int i = 0; i < testTime; i++) {
//            int[] array = generateRandomArray(maxSize, maxValue);
//            int a1 = getMax(array);
//            int a2 = getMax_test(array);
//            if (a1 != a2) {
//                System.out.println("----");
//                break;
//            }
//
//        }
//        System.out.println("end---");
        System.out.println(getMax(new int[]{0,0,0,1}));

    }
}
