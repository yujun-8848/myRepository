package class05_test;

import java.util.Arrays;

/**
 * @author yujun
 * @Description https://leetcode.com/problems/count-of-range-sum/
 * 给定一个数组arr，两个整数lower和upper
 * 返回arr中有多少个子数组的累加和在[lower,upper]范围上 ON(N * longN)
 * coding 小技巧
 * 累加和： 优先考虑前缀数组，可以很明显的降低代码的时间复杂度 QAQ-QAQ
 * @Date 2021/11/5
 */
public class Code01_CountOfRangeSum {

    public static int countRangeSum_test(int[] arr, int lower, int upper) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int ans = 0;
        int[] sum = preSum(arr);
        for (int i = 0; i < sum.length; i++) {
            for (int j = i; j < sum.length; j++) {
                if (i == j) {
                    if (sum[i] >= lower && sum[i] <= upper) {
                        ans++;
                        continue;
                    }
                }
                if ((j - i) == sum.length - 1) {
                    continue;
                }
                if ((sum[j] - sum[i]) >= lower && (sum[j] - sum[i]) <= upper) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int countRangeSum(int[] arr, int lower, int upper) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] sum = preSum(arr);
        return process(sum, 0, sum.length - 1, lower, upper);
    }

    //递归定义:在sum前缀数组sum[L...R]中，排有序且返回累加和在[lower,upper]中
    private static int process(int[] sum, int L, int R, int lower, int upper) {
        //base case
        if (L == R) {
            return sum[L] >= lower && sum[R] <= upper ? 1 : 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(sum, L, mid, lower, upper)
                + process(sum, mid + 1, R, lower, upper)
                + mergeSort(sum, L, mid, R, lower, upper);
    }

    //
    private static int mergeSort(int[] sum, int L, int mid, int R, int lower, int upper) {
        int ans = 0;
        //初始状态[L,L)，左闭右开
        int windowL = L;
        int windowR = L;
        for (int i = mid + 1; i <= R; i++) {
            //左组左下标：windowL min
            //左组右下标：windowR max
            int min = sum[i] - upper;
            int max = sum[i] - lower;
            //窗口不回退，直到sum[windowL]>max停止
            while (windowR <= mid && sum[windowR] <= max) {
                windowR++;
            }
            //窗口不回退，直到sum[windowL]>=min停止
            while (windowL <= mid && sum[windowL] < min) {
                windowL++;
            }
            ans += windowR - windowL;
        }
        //归并排序
        int[] help = new int[R - L + 1];
        int p = 0;
        int left = L;
        int right = mid + 1;
        while (left <= mid && right <= R) {
            help[p++] = sum[left] <= sum[right] ? sum[left++] : sum[right++];

        }
        while (left <= mid) {
            help[p++] = sum[left++];
        }
        while (right <= R) {
            help[p++] = sum[right++];
        }
        if (help.length >= 0) {
            System.arraycopy(help, 0, sum, L, help.length);
        }
        return ans;
    }

    //前缀数组
    //如果想要求arr[i..j]之间的累加和
    //即是求sum[i...j] = sum[j] - sum[i-1];
    //如果已j为结束点，则[lower,upper]则 sum[i-1]的范围要在[sum[j] - upper,sum[j] - lower]之间
    public static int[] preSum(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        return sum;
    }

    public static int[] generateArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
        }
        return arr;
    }


    public static void main(String[] args) {
        System.out.println("start---");
        int testTime = 10000;
        int maxSize = 10;
        int maxValue = 10;
        for (int i = 0; i < testTime; i++) {
            int[] array = generateArray(maxSize, maxValue);
            int[] arr2 = new int[array.length];
            System.arraycopy(array, 0, arr2, 0, array.length);
            int lower = (int) (maxSize * Math.random());
            int upper = (int) (maxSize * Math.random());
            lower = Math.min(lower, upper);
            upper = Math.max(lower, upper);
            if (lower == upper) {
                continue;
            }
            if (countRangeSum(array, lower, upper) != countRangeSum_test(arr2, lower, upper)) {
                System.out.println("fail--");
                System.out.println(Arrays.toString(array));
                System.out.println(lower);
                System.out.println(upper);
                break;
            }
        }
        System.out.println("end---");
    }
}
