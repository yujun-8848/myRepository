package class23_test;

/**
 * @author yujun
 * @Description 给定一个正数数组arr，请把arr中所有的数分成两个集合
 * 如果arr长度为偶数，两个集合包含数的个数要一样多
 * 如果arr长度为奇数，两个集合包含数的个数必须只差一个
 * 请尽量让两个集合的累加和接近
 * 返回：
 * 最接近的情况下，较小集合的累加和
 * @Date 2021/12/7
 */
public class Code02_SplitSumClosedSizeHalf {

    public static int right(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        //偶数个
        if ((arr.length & 1) == 0) {

            return process(arr, 0, arr.length / 2, sum / 2);
        } else {
            //奇数个
            return Math.max(process(arr, 0, arr.length / 2, sum / 2), process(arr, 0, arr.length / 2 + 1, sum / 2));
        }
    }

    public static int dp(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        sum /= 2;
        int N = arr.length;
        int M = (N + 1) / 2;
        int[][][] dp = new int[N + 1][M + 1][sum + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= sum; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        for (int rest = 0; rest <= sum; rest++) {
            dp[N][0][rest] = 0;
        }
        for (int index = N - 1; index >= 0; index--) {
            for (int picks = 0; picks <= M; picks++) {
                for (int rest = 0; rest <= sum; rest++) {
                    int p1 = dp[index + 1][picks][rest];
                    int next = -1;
                    if (rest - arr[index] >= 0 && picks - 1 >= 0) {
                        next = dp[index + 1][picks - 1][rest - arr[index]];
                    }
                    int p2 = -1;
                    if (next != -1) {
                        p2 = arr[index] + next;
                    }
                    dp[index][picks][rest] = Math.max(p1, p2);
                }
            }
        }
        //偶数个
        if ((arr.length & 1) == 0) {
            return dp[0][N / 2][sum];
        } else {
            //奇数个
            return Math.max(dp[0][N / 2][sum], dp[0][M][sum]);
        }
    }

    // arr[i....]自由选择，挑选的个数一定要是picks个，累加和<=rest, 离rest最近的返回
    public static int process(int[] arr, int index, int picks, int rest) {
        if (index == arr.length) {
            return picks == 0 ? 0 : -1;
        }
        int p1 = process(arr, index + 1, picks, rest);
        int next = -1;
        if (rest - arr[index] >= 0) {
            next = process(arr, index + 1, picks - 1, rest - arr[index]);
        }
        int p2 = -1;
        if (next != -1) {
            p2 = arr[index] + next;
        }
        return Math.max(p1, p2);
    }

    // for test
    public static int[] randomArray(int len, int value) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * value);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int maxLen = 10;
        int maxValue = 50;
        int testTime = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * maxLen);
            int[] arr = randomArray(len, maxValue);
            int ans1 = right(arr);
            int ans2 = dp(arr);
            if (ans1 != ans2) {
                printArray(arr);
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试结束");
    }
}
