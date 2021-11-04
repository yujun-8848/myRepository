package class04_test;

/**
 * @author yujun
 * @Description 在一个数组中，
 * 任何一个前面的数a，和任何一个后面的数b
 * 如果(a,b)是降序的，就称为逆序对
 * 返回数组中所有的逆序对
 * @Date 2021/11/4
 */
public class Code03_ReversePair {

    public static int reverPairNumber_test(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int reverPairNumber(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);

    }

    //递归定义: arr[L...R] 排有序且返回逆序对个数
    //总结：x右侧有多少个数比它小
    public static int process(int[] arr, int L, int R) {
        //base case
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid)
                + process(arr, mid + 1, R)
                + mergeSort(arr, L, mid, R);

    }

    //下标不回退，从右向左merge
    private static int mergeSort(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int p = help.length - 1;
        int left = mid;
        int right = R;
        int ans = 0;
        while (left >= L && right >= (mid + 1)) {
            ans += arr[left] > arr[right] ? (right - mid) : 0;
            help[p--] = arr[left] > arr[right] ? arr[left--] : arr[right--];

        }
        while (left >= L) {
            help[p--] = arr[left--];
        }
        while (right >= (mid + 1)) {
            help[p--] = arr[right--];
        }
        if (help.length >= 0) {
            System.arraycopy(help, 0, arr, L, help.length);
        }
        return ans;
    }

    //对数器
    public static int[] generateArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
        }
        return arr;
    }

    //比较
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 != null || (arr1 != null && arr2 == null)) {
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

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] ans = new int[arr.length];
        System.arraycopy(arr, 0, ans, 0, arr.length);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("start--QAQ");
        int testTime = 10000;
        int maxSize = 10;
        int maxValue = 10;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr);
            int ans1 = reverPairNumber_test(arr);
            int ans2 = reverPairNumber(arr2);
            if (ans1 != ans2) {
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("fail--");
                break;
            }
        }
        System.out.println("end--QAQ");
    }
}
