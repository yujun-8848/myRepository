package com.leetcode.cn.com.bit.cn;

/**
 * 给定一个整数，编写一个函数来判断它是否是2的幂次方
 */
public class IsPowerOfTwo {

    /**
     * input 1  return true
     * input 16 return true
     * input 218 return false
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return (n > 0) &&(n & (n - 1)) == 0;

    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(9));
    }
}
