package com.leetcode.cn.algorithm.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 * 示例1：
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 */
public class Q01_04 {

    public static boolean canPermutePalindrome(String s) {

      Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if(set.contains(c)){
                set.remove(c);
            }else {
                set.add(c);
            }
        }
        return set.size() <=1;
    }

    public static void main(String[] args) {
        String s = "tactcoa";
        System.out.println(canPermutePalindrome(s));
    }
}
