package class22_test;

/**
 * @author yujun
 * @Description 给定3个参数，N，M，K
 * 怪兽有N滴血，等着英雄来砍自己
 * 英雄每一次打击，都会让怪兽流失[0~M]的血量
 * 到底流失多少？每一次在[0~M]上等概率的获得一个值
 * 求K次打击之后，英雄把怪兽砍死的概率
 * @Date 2021/12/7
 */
public class Code01_KillMonster {

    public static double right(int N, int M, int K) {
        if (N < 1 || M < 1 || K < 1) {
            return 0;
        }
        long all = (long) Math.pow(M + 1, K);
        long kill = process(K, M, N);
        return ((double) kill / (double) all);
    }

    public static double dp(int N, int M, int K) {
        if (N < 1 || M < 1 || K < 1) {
            return 0;
        }
        long[][] dp = new long[K + 1][N + 1];
        dp[0][0] = 1;
        for (int rest = 1; rest <= K; rest++) {
            dp[rest][0] = (long) Math.pow(M + 1, rest);
            for (int hp = 1; hp <= N; hp++) {
                int ways = 0;
                for (int i = 0; i <= M; i++) {
                    if (hp - i <= 0) {
                        ways += (long) Math.pow(M + 1, rest - 1);
                    } else
                        ways += dp[rest - 1][hp - i];
                }
                dp[rest][hp] = ways;
            }
        }
        long kill = dp[K][N];
        long all = (long) Math.pow(M + 1, K);
        return (double) ((double) kill / (double) all);
    }

    public static long process(int rest, int M, int hp) {
        if (rest == 0) {
            return hp <= 0 ? 1 : 0;
        }
        if (hp <= 0) {
            return (long) Math.pow(M + 1, rest);
        }
        int ways = 0;
        for (int i = 0; i <= M; i++) {
            ways += process(rest - 1, M, hp - i);
        }
        return ways;
    }

    public static void main(String[] args) {
        int NMax = 10;
        int MMax = 10;
        int KMax = 10;
        int testTime = 200;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int N = (int) (Math.random() * NMax);
            int M = (int) (Math.random() * MMax);
            int K = (int) (Math.random() * KMax);
            double ans1 = right(N, M, K);
            double ans2 = dp(N, M, K);
//            double ans3 = dp2(N, M, K);
            if (ans1 != ans2) {
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试结束");
    }
}
