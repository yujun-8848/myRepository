package com.leetcode.cn.com.bit.cn;

/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为1的个数
 */
public class HamMingWeight {

    /**
     * 任何数与1位与，可以得到数的最后一位数字
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;

    }

    public static int hammingWeight2(int n){
        int sum = 0;
        while (n !=0 ){
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        int num = 00000000000000000000100101111;
        System.out.println(hammingWeight(num));
        System.out.println(hammingWeight2(num));
    }
}
