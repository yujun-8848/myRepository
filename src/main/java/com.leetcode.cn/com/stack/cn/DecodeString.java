package com.leetcode.cn.com.stack.cn;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class DecodeString {

    public String decodeString(String s) {

        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            if (c == ']') {
                String str = "";
                while (!stack.peek().equals("[")) {
                    str = stack.pop() + str;
                }
                stack.pop();
                String countStr = "";
                while (!stack.isEmpty() && stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
                    countStr = stack.pop() + countStr;
                }
                int count = Integer.parseInt(countStr);
                String res = "";
                for (int i = 0; i < count; i++) {
                    res = res + str;
                }
                stack.push(res);
            } else {
                String str = "";
                stack.push(str + c);
            }
        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "100[leedcode]";
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString(s));
    }
}
