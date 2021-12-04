package class20_test;

/**
 * @author yujun
 * @Description 给定一个字符串str，返回这个字符串的最长回文子序列长度
 * 比如 ： str = “a12b3c43def2ghi1kpm”
 * 最长回文子序列是“1234321”或者“123c321”，返回长度7
 * @Date 2021/12/4
 * <p>
 * 范围尝试模型
 */
public class Code01_PalindromeSubsequence {

    public static int lpsl1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        return process(str, 0, str.length - 1);
    }

    //str[L...R]尝试所有可能性，返回最长回文子序列的长度
    public static int process(char[] str, int L, int R) {
        if (L == R) {
            return 1;
        }
        if (L == R - 1) {
            //只有两个且值相等
            return str[L] == str[R] ? 2 : 1;
        }
        //可能性
        int p1 = process(str, L + 1, R - 1);
        //可能性
        int p2 = process(str, L + 1, R);
        //可能性
        int p3 = process(str, L, R - 1);
        //可能性
        int p4 = str[L] == str[R] ? 2 + process(str, L + 1, R - 1) : 0;
        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }

    public static int dp(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < N - 1; i++) {
            dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
        }
        for (int L = N - 3; L >= 0; L--) {
            for (int R = L + 2; R < N; R++) {
                //分析位置依赖关系， 优化
                dp[L][R] = Math.max(dp[L + 1][R], dp[L][R - 1]);
                if (str[L] == str[R]) {
                    dp[L][R] = Math.max(dp[L][R], 2 + dp[L + 1][R - 1]);
                }
            }
        }
        return dp[0][N - 1];
    }
}
