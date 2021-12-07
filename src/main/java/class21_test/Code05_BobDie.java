package class21_test;

/**
 * @author yujun
 * @Description 给定5个参数，N，M，row，col，k
 * 表示在N*M的区域上，醉汉Bob初始在(row,col)位置
 * Bob一共要迈出k步，且每步都会等概率向上下左右四个方向走一个单位
 * 任何时候Bob只要离开N*M的区域，就直接死亡
 * 返回k步之后，Bob还在N*M的区域的概率
 * @Date 2021/12/7
 */
public class Code05_BobDie {

    public static double livePosibility1(int row, int col, int k, int N, int M) {
        return (double) process(row, col, k, N, M) / Math.pow(4, k);
    }

    public static double dp(int row, int col, int k, int N, int M) {
        long[][][] dp = new long[N][M][k + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j][0] = 1;
            }
        }
        for (int rest = 1; rest <= k; rest++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    dp[i][j][rest] = pick(dp, row + 1, col, rest - 1, N, M);
                    dp[i][j][rest] += pick(dp, row - 1, col, rest - 1, N, M);
                    dp[i][j][rest] += pick(dp, row, col + 1, rest - 1, N, M);
                    dp[i][j][rest] += pick(dp, row, col - 1, rest - 1, N, M);
                }
            }
        }
        return (double) dp[row][col][k] / Math.pow(4, k);
    }

    public static long pick(long[][][] dp, int row, int col, int k, int N, int M) {
        if (row < 0 || row == N || col < 0 || col == M) {
            return 0;
        }
        return dp[row][col][k];
    }

    public static int process(int row, int col, int rest, int N, int M) {
        if (row < 0 || row == N || col < 0 || col == M) {
            return 0;
        }
        if (rest == 0) {
            return 1;
        }
        int ways = process(row + 1, col, rest - 1, N, M);
        ways += process(row - 1, col, rest - 1, N, M);
        ways += process(row, col + 1, rest - 1, N, M);
        ways += process(row, col - 1, rest - 1, N, M);
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(livePosibility1(6, 6, 10, 50, 50));
        System.out.println(dp(6, 6, 10, 50, 50));
    }

}
