package com.leetcode.cn.com.backtracking.cn;

import com.daml.dti.function.person.GsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * <p>
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 * <p>
 * S 的长度不超过12。
 * S 仅由数字和字母组成
 */
public class LetterCasePermutation {

    private List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        char[] charArray = new char[s.length()];
        if (s.length() == 0) {
            return res;
        }
        dfs(s, 0, charArray);
        return res;
    }

    public void dfs(String s, int start, char[] charArray) {
        int len = s.length();
        if (start == len) {
            res.add(new String(charArray));
            return;
        }
        charArray[start] = s.charAt(start);
        dfs(s, start + 1, charArray);
        if (Character.isLetter(s.charAt(start))) {
            charArray[start] = (char) (s.charAt(start) ^ (1 << 5));
            dfs(s, start + 1, charArray);

        }
    }

    public static void main(String[] args) {
        //大小写互转
     /*   char a = 'a';
        System.out.println((char) (a ^ (1 << 5)));*/
        String s = "a1b2";
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        System.out.println(letterCasePermutation.letterCasePermutation(s));
        String e = "";
        System.out.println(-3 << 2);
        int i = -8;
        System.out.println(i >> 2);

        List<Integer> lsit = new ArrayList<>();
        lsit.add(1);
        lsit.add(2);
        lsit.forEach(integer -> System.out.println(integer));


    }
}
