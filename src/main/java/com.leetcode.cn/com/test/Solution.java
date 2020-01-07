package com.leetcode.cn.com.test;

import java.util.*;

/**
 * Created by Administrator on 2019/12/16.
 */

public class Solution {

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");

        System.out.println(new Solution().wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.equals("")) {
            return true;
        }
        for (String word : wordDict) {
            if (s.startsWith(word) && wordBreak(s.substring(word.length()), wordDict)) {
                return true;
            }
        }
        return false;
    }

}