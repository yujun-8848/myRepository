package class01_test;

import java.util.Arrays;

/**
 * @author yujun
 * 二分法
 * @Description 在一个有序数组中，找>=某个数最左侧的位置
 * @Date 2021/10/29
 */
public class Code05_BSNearLeft {

    public static int nearestIndexTest(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }

    public static int nearestIndex(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid;
        int index = -1;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else if (arr[mid] < value) {
                L = mid + 1;
            }

        }
        return index;

    }

    public static int[] generaryArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
        }
        Arrays.sort(arr);
        return arr;
    }

    public static boolean isEqual(int a1, int a2) {
        return a1 == a2;
    }

    public static void test() {
        System.out.println("开始测试");
        int testTime = 1000;
        int maxSize = 10;
        int maxValue = 10;
        int value = 10;
        for (int i = 0; i < testTime; i++) {
            int[] array = generaryArray(maxSize, maxValue);
            int a1 = nearestIndex(array, value);
            int a2 = nearestIndexTest(array, value);
            if (!isEqual(a1, a2)) {
                System.out.println(Arrays.toString(array));
                System.out.println(value);
                break;
            }
        }
        System.out.println("结束测试");

    }

    public static void main(String[] args) {
        test();
//        int[] arr = {-4, -1, 7, 10};
//        int value = 10;
//        System.out.println(nearestIndex(arr, value));
    }


}
