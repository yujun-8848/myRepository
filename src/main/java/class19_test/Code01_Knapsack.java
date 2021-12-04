package class19_test;

/**
 * @author yujun
 * @Description 给定两个长度都为N的数组weights和values，
 * weights[i]和values[i]分别代表 i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，
 * 你装的物品不能超过这个重量。
 * 返回你能装下最多的价值是多少?
 * 从左到右模型
 * @Date 2021/12/2
 */
public class Code01_Knapsack {

    // 所有的货，重量和价值，都在w和v数组里
    // 为了方便，其中没有负数
    // bag背包容量，不能超过这个载重
    // 返回：不超重的情况下，能够得到的最大价值
    public static int maxValue(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        // 尝试函数！
        return process(w, v, 0, bag);
    }

    // 所有的货，重量和价值，都在w和v数组里
    // 为了方便，其中没有负数
    // bag背包容量，不能超过这个载重
    // 返回：不超重的情况下，能够得到的最大价值
    public static int dp(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int cur = N - 1; cur >= 0; cur--) {
            for (int rest = 0; rest <= bag; rest++) {
                //可能性1 不选
                int p1 = dp[cur + 1][rest];
                //可能性2 选
                int p2 = Integer.MIN_VALUE;
                if (rest - w[cur] >= 0) {
                    p2 = v[cur] + dp[cur + 1][rest - w[cur]];
                }
                dp[cur][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    //在arr[cur...]中，满足不超过载重的条件下，最大价值
    public static int process(int[] w, int[] v, int cur, int rest) {
        if (rest < 0) {
            return Integer.MIN_VALUE;
        }
        if (cur == w.length) {
            return 0;
        }
        //可能性1 不选
        int p1 = process(w, v, cur + 1, rest);
        //可能性2 选
        int p2 = process(w, v, cur + 1, rest - w[cur]);
        if (p2 != Integer.MIN_VALUE) {
            p2 += v[cur];
        }
        return Math.max(p1, p2);
    }


    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7, 3, 1, 7};
        int[] values = {5, 6, 3, 19, 12, 4, 2};
        int bag = 12;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(dp(weights, values, bag));
    }
}
