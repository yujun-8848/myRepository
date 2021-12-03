package class18_test;

/**
 * @author yujun
 * @Description 给定一个整型数组arr，代表数值不同的纸牌排成一条线
 * 玩家A和玩家B依次拿走每张纸牌
 * 规定玩家A先拿，玩家B后拿
 * 但是每个玩家每次只能拿走最左或最右的纸牌
 * 玩家A和玩家B都绝顶聪明
 * 请返回最后获胜者的分数。
 * @Date 2021/12/2
 * <p>
 * 范围模型
 */
public class Code02_CardsInLine {

    public static int win1(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int first = f(arr, 0, arr.length - 1);
        int second = g(arr, 0, arr.length - 1);
        return Math.max(first, second);
    }


    public static int win2(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fdp = new int[N][N];
        int[][] gdp = new int[N][N];
        for (int i = 0; i < N; i++) {
            fdp[i][i] = arr[i];
        }
        for (int starCol = 1; starCol < N; starCol++) {
            int L = 0;
            int R = starCol;
            while (R < N) {
                fdp[L][R] = Math.max(arr[L] + gdp[L + 1][R], arr[R] + gdp[L][R - 1]);
                gdp[L][R] = Math.min(fdp[L + 1][R], fdp[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(fdp[0][N - 1], gdp[0][N - 1]);
    }

    // 在arr[L...R]中先手拿牌返回分数
    public static int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int p1 = arr[L] + g(arr, L + 1, R);
        int p2 = arr[R] + g(arr, L, R - 1);
        return Math.max(p1, p2);
    }

    // 在arr[L...R]中后手拿牌返回分数
    public static int g(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int p1 = f(arr, L + 1, R); // 对手拿走了L位置的数
        int p2 = f(arr, L, R - 1); // 对手拿走了R位置的数
        return Math.min(p1, p2);
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7};
        System.out.println(win1(arr));
        System.out.println(win2(arr));
//        System.out.println(win3(arr));
    }

}
