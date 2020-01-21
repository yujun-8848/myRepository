package com.leetcode.cn.string.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * 示例 1：
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 */
public class FindSubstring {
    /**
     * 使用滑动窗口的形式来实现完全匹配或者字符串匹配的方式.
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.isEmpty() || words.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int wordNum = words.length;
        int wordLen = words[0].length();
        int allWord = wordLen * wordNum;
        for (int i = 0; i < s.length() - allWord + 1; i++) {
            String subStr = s.substring(i, i + allWord);
            Map<String, Integer> temp = new HashMap<>();
            for (int j = 0; j < subStr.length(); j += wordLen) {
                String subStr2 = subStr.substring(j, j + wordLen);
                temp.put(subStr2, temp.getOrDefault(subStr2, 0) + 1);
                if (!map.containsKey(subStr2)) {
                    break;
                }
            }
            if (temp.equals(map)) {
                res.add(i);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        FindSubstring findSubstring = new FindSubstring();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring.findSubstring(s, words));
    }
}
