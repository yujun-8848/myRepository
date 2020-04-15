package com.leetcode.cn.algorithm.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * 输入: s = "abc"
 * 输出: true
 */
public class Q01_01 {

    public static boolean isUnique(String astr) {

        Set<Character> set = new HashSet<>();
        for (char c : astr.toCharArray()) {
            if(!set.contains(c)){
                set.add(c);
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("letcode"));
    }
}
