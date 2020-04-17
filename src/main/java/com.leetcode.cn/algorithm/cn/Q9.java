package com.leetcode.cn.algorithm.cn;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Q9 {

    /**
     * 如果将数字进行反转再进行比较，反转后的数字会大于Int.MAX,
     * 故只取部分的值进行比较
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reveseNumber = 0;
        while (x > reveseNumber) {
            reveseNumber = reveseNumber * 10 + x % 10;
            x /= 10;
        }
        return x == reveseNumber || x == reveseNumber / 10;

        /*    StringBuilder res = new StringBuilder();
        int n =x;
        while (n > 0){
            int a = n %10;
            res.append(a);
            n = n /10;
        }
        return x == Integer.parseInt(res.toString());*/
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(2147481345));
    }
}
