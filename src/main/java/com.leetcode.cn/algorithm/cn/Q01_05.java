package com.leetcode.cn.algorithm.cn;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，
 * 编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * 示例 1:
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * 示例 2:
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 */
public class Q01_05 {

    public static boolean oneEditAway(String first, String second) {

        int len = first.length() - second.length();
        if(len < -1 || len > 1){
            return false;
        }
        int count = 0;
        for (int i = 0, j = 0; i < first.length()&& j < second.length(); i++,j++) {
            if(first.charAt(i) != second.charAt(j)){
                if(len == 1){
                    j--;
                }else if(len == -1){
                    i--;
                }
                count++;
            }
            if(count >1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(oneEditAway("pales", "ple"));
    }
}
