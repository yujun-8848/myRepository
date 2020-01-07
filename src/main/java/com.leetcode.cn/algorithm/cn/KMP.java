package com.leetcode.cn.algorithm.cn;

/**
 * Created by Administrator on 2019/12/30.
 */
public class KMP {

    public static void main(String[] args) {
        String a = "BBC ABCDAB ABCDABCDABDE";
        String b = "ABCDABD";
        //System.out.println(violenceMatch(a, b));
        int[] next = kmpNext(b);
        System.out.println(search(a, b, next));
    }


    public static int search(String src, String dest, int[] next) {
        for (int i = 0, j = 0; i < src.length(); i++) {

            while (j > 0 && src.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (src.charAt(i) == dest.charAt(j)) {
                j++;
            }
            if (j == dest.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    //转移数组
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {

            //KMP核心思想
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static boolean violenceMatch(String str1, String str2) {

        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int i = 0;
        int j = 0;
        while (i < char1.length && j < char2.length) {
            if (char1[i] == char2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == char2.length) {
            return true;
        }
        return false;
    }
}
