package com.leetcode.cn.com.sort.cn;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubble {

    public int[] bubbleSort(int[] nums) {

        boolean flag = false;
        int temp;
        for (int k = 0; k < nums.length - 1; k++) {
            for (int i = 0; i < nums.length - 1 - k; i++) {
                int j = i + 1;
                if (nums[i] > nums[j]) {
                    flag = true;
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }

            if (!flag) {
                break;
            }else {
                flag = false;
            }
        }
        return nums;

    }

    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(bubble.bubbleSort(nums)));
    }

}
