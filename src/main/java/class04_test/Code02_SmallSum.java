package class04_test;

/**
 * @author yujun
 * @Description 在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。
 * 例子： [1,3,4,2,5]
 * 1左边比1小的数：没有
 * 3左边比3小的数：1
 * 4左边比4小的数：1、3
 * 2左边比2小的数：1
 * 5左边比5小的数：1、3、4、 2
 * 所以数组的小和为1+1+3+1+1+3+4+2=16
 * @Date 2021/11/4
 */
public class Code02_SmallSum {

    public static int smallSum_test(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int ans = 0;
        //0...N-1
        //1...N-1
        //2...N-1
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    ans += arr[j];
                }
            }
        }
        return ans;
    }

    //小和问题进行转换：一个数右边有多少个数比它大，
    //假如该数是x，有N个数比他大，则小和为N * x;
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);

    }

    //递归定义arr[L...R]，arr中排好序，且产生小和
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

    private static int mergeSort(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int p = 0;
        int left = L;
        int right = mid + 1;
        int ans = 0;
        while (left <= mid && right <= R) {
            //如果相等不产生小和，方便定位有多少个大于arr[p]数。
            ans += arr[left] < arr[right] ? arr[left] * (R - right + 1) : 0;
            //相等时，优先移动右边的值
            help[p++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
        }
        while (left <= mid) {
            help[p++] = arr[left++];
        }
        while (right <= R) {
            help[p++] = arr[right++];
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
            int ans1 = smallSum_test(arr);
            int ans2 = smallSum(arr2);
            if( ans1 != ans2){
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("fail--");
                break;
            }
        }
        System.out.println("end--QAQ");


    }
}
