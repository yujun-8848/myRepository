package com.leetcode.cn.com.bit.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，某余每个元素均出现两次。
 * 找出那个只出现一次的元素
 */
public class SingleNumber {

    /**
     * input [2,2,1] output 1
     * input [4,1,2,1,2] output 4
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer res = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], res);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 使用位运算 异或
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    /**
     * 若将条件改为相同元素出现3次，求只出现一次的元素
     *
     * @param nums
     * @return
     */
    public static int singleNumber3(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;

    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 6};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber2(nums));
        int[] nums2 = {1,1,1,2,2,2,4};
        System.out.println(singleNumber3(nums2));
    }
}
