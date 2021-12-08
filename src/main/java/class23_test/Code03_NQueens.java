package class23_test;

/**
 * @author yujun
 * @Description N皇后问题是指在N*N的棋盘上要摆N个皇后，
 * 要求任何两个皇后不同行、不同列， 也不在同一条斜线上
 * 给定一个整数n，返回n皇后的摆法有多少种。n=1，返回1
 * n=2或3，2皇后和3皇后问题无论怎么摆都不行，返回0
 * n=8，返回92
 * @Date 2021/12/7
 * <p>
 * 从左向右尝试模型
 */
public class Code03_NQueens {

    public static int num(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n);
    }

    //index...行 考虑棋子摆放在哪一列
    //使用record数组记录摆放的位置点，record[x] = y
    //摆放前需要先判断棋子是否与之前的棋子处在同行或者同列或者同斜线
    //返回：不关心index以上发生了什么，index...后续有多少合法的方法数
    public static int process(int index, int[] record, int n) {
        if (index == n) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (isValid(record, index, i)) {
                record[index] = i;
                ans += process(index + 1, record, n);
            }
        }
        return ans;
    }

    //判断index行i列的棋子是否与record中的棋子存在同行同列同斜线问题
    public static boolean isValid(int[] record, int index, int i) {
        for (int j = 0; j < index; j++) {
            //同列
            //Math.abs(index - j) == Math.abs(record[j] - i)
            //上下两行的 行列之差的绝对值判断是否存在同列同斜线问题
            if (record[j] == i || Math.abs(index - j) == Math.abs(record[j] - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(num(n));
    }
}
