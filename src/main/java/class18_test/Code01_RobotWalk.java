package class18_test;

/**
 * @author yujun
 * @Description 假设有排成一行的N个位置，记为1~N，N 一定大于或等于 2
 * 开始时机器人在其中的M位置上(M 一定是 1~N 中的一个)
 * 如果机器人来到1位置，那么下一步只能往右来到2位置；
 * 如果机器人来到N位置，那么下一步只能往左来到 N-1 位置；
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 * 规定机器人必须走 K 步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * 给定四个参数 N、M、K、P，返回方法数。
 * <p>
 * 从左到右尝试模型
 * @Date 2021/12/2
 */
public class Code01_RobotWalk {

    public static int ways1(int N, int start, int aim, int K) {
        if (start < 1 || start > N || aim < 1 || aim > N || K < 0) {
            return 0;
        }
        return process(N, start, aim, K);
    }

    //动态规划
    public static int dp(int N, int start, int aim, int K) {
        if (start < 1 || start > N || aim < 1 || aim > N || K < 0) {
            return 0;
        }
        int[][] dp = new int[N + 1][K + 1];
        dp[aim][0] = 1;
        for (int rest = 1; rest <= K; rest++) {
            dp[1][rest] = dp[2][rest - 1];
            for (int cur = 2; cur < N; cur++) {
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }
        return dp[start][K];
    }

    /**
     * @param N    总共有n个位置
     * @param cur  机器人开始的位置(i...)
     * @param aim  需要到达的目标位置
     * @param rest 剩余步数
     * @return 返回在(i..)位置下，在rest步数下达到aim的方法数
     */
    public static int process(int N, int cur, int aim, int rest) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return process(N, cur + 1, aim, rest - 1);
        }
        if (cur == N) {
            return process(N, cur - 1, aim, rest - 1);
        }
        //正常情况下
        //向左走
        int p1 = process(N, cur - 1, aim, rest - 1);
        //向右走
        int p2 = process(N, cur + 1, aim, rest - 1);
        return p1 + p2;
    }

    public static void main(String[] args) {
        // 1 2 3 4
        System.out.println(ways1(4, 2, 3, 3));
        System.out.println(dp(4, 2, 3, 3));
    }
}
