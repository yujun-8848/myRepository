package com.leetcode.cn.com.greedy.cn;

import java.util.Properties;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class CanJump {

    public boolean canJump(int[] nums) {

        int max = 0;
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(i + nums[i], max);
            if (max <= i ) {
                return false;
            }
        }
        return true;
    }

    // 根据Unicode编码完美的判断中文汉字
    public boolean isChinese(char c) {

        Properties properties = System.getProperties();
        //遍历所有的属性
        for (String key : properties.stringPropertyNames()) {
            //输出对应的键和值
            System.out.println(key + "=" + properties.getProperty(key));
        }

        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        int[] nums = {1,1,1,0};
        System.out.println(canJump.canJump(nums));
        System.out.println(canJump.isChinese('䶮'));




    }
}
