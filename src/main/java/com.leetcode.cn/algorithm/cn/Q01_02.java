package com.leetcode.cn.algorithm.cn;

import java.util.Arrays;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 示例 1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 */
public class Q01_02 {

    public static boolean CheckPermutation(String s1, String s2) {

        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);
        return Arrays.toString(c1).equals(Arrays.toString(c2));

    }

    public static void main(String[] args) {
        System.out.println(CheckPermutation("abcea", "bcaae"));
    }
}
