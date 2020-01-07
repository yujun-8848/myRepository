package com.leetcode.cn.com.backtracking.cn;

/**
 * 八皇后问题
 */
public class EightQueens {

    private int max = 8;
    public int[] arr = new int[max];
    private static int count;

    public boolean judge(int n) {
        if (n < 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return true;
            }
        }
        return false;
    }

    public void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (!judge(n)) {
                check(n + 1);
            }
        }
    }

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.check(0);
        System.out.println(count);
    }

    public void print(){
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
