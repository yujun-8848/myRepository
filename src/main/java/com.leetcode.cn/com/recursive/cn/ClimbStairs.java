package com.leetcode.cn.com.recursive.cn;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbStairs {

    public static int climbStairs(int n) {

        if (n == 1 || n == 2) {
            return n == 1 ? 1 : 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n == 1 ? 1 : 2;
        }
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        int i = 3;
        while (i <= n) {
            res[i] = res[i - 1] + res[i - 2];
            i++;
        }
        return res[i - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs2(45));
    }
}
