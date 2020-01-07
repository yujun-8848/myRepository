package com.leetcode.cn.com.stack.cn;

import java.util.Stack;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {

        if (k > num.length() || num.length() == 0) {

            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        for (char c : num.toCharArray()) {

            int now = c - '0';
            while (!stack.isEmpty() && k > 0 && now < stack.peek()) {
                stack.pop();
                k--;
            }
            if (now != 0 ||!stack.isEmpty()) {
                stack.push(now);
            }
        }
        if (stack.isEmpty()) {
            return "0";
        }
        while (k > 0) {
            k--;
            stack.pop();
        }
        if (stack.isEmpty()) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num = "10";
        RemoveKdigits removeKdigits = new RemoveKdigits();
        String kdigits = removeKdigits.removeKdigits(num,2);
        System.out.println(kdigits);
    }
}
