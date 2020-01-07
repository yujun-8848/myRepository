package com.leetcode.cn.com.recursive.cn;

/**
 * 泰波那契序列 Tn 定义如下： 
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * 示例 1：
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * 输入：n = 25
 * 输出：1389537
 */
public class Tribonacci {

    public static int tribonacci(int n) {

        if (n == 0 || n == 1 || n == 2) {
            return n == 0 ? 0 : 1;
        }
        return tribonacci(n -1) + tribonacci(n - 2) + tribonacci(n - 3);

    }

    public static int tribonacci2(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n == 0 ? 0 : 1;
        }
        int[] res = new int[n +1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        int i =3;
        while (i <= n){
            res[i] = res[i -2] +res[i -1] +res[i -3];
            i++;
        }
        return res[i -1];
    }

    public static void main(String[] args) {
        System.out.println(tribonacci2(25));
    }

}
