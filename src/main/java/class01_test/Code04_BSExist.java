package class01_test;

import java.util.Arrays;

/**
 * @author yujun
 * 二分法
 * @Description 在一个有序数组中，找某个数是否存在
 * @Date 2021/10/29
 */
public class Code04_BSExist {
    public static boolean existTest(int[] sortedArr, int num) {
        if (sortedArr == null) {
            return false;
        }
        if (sortedArr.length == 1 && sortedArr[0] != num) {
            return false;
        }
        for (int i = 0; i < sortedArr.length; i++) {
            if (sortedArr[i] == num) {
                return true;
            }
        }
        return false;

    }

    public static boolean exist(int[] sortedArr, int num) {

        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        if (sortedArr.length == 1 && sortedArr[0] != num) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        while (L < R) {

            //后面必须加括号
            int mid = L + ((R - L) >> 1);
            if (sortedArr[mid] > num) {
                R = mid;
            } else if (sortedArr[mid] < num) {
                L = mid + 1;
            } else {
                return true;
            }
        }
        return sortedArr[L] == num;

    }

    public static int[] generayArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
        }
        Arrays.sort(arr);
        return arr;
    }

    public static boolean isEqual(boolean a1, boolean a2) {
        return a1 == a2;
    }

    public static void test() {
        System.out.println("开始测试");
        int testTime = 100;
        int maxSize = 10;
        int maxValue = 10;
        int num = 10;
        for (int i = 0; i < testTime; i++) {
            int[] array = generayArray(maxSize, maxValue);
            boolean a1 = exist(array, num);
            boolean a2 = existTest(array, num);
            if (!isEqual(a1, a2)) {
                System.out.println(Arrays.toString(array));
                System.out.println(num);
                break;
            }

        }
        System.out.println("结束测试");

    }

    public static void main(String[] args) {
        test();
//        int[] arr = {-7, -4, -2, 0, 1, 1, 8, 10};
//        int num = 10;
//        System.out.println(exist(arr, num));
    }

}
