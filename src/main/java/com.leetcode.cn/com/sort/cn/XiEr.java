package com.leetcode.cn.com.sort.cn;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class XiEr {

    public int[] xierSort(int[] nums) {

        int len = nums.length;
        int step = len / 2;
        while (step > 0) {

            for (int i = 0; i < nums.length - step; i++) {
                if (nums[i] > nums[i + step]) {
                    int temp = nums[i];
                    nums[i] = nums[i + step];
                    nums[i + step] = temp;
                }
            }
            step /= 2;

        }
        return nums;

    }

    public static void main(String[] args) {
        XiEr xiEr = new XiEr();
        int[] nums = {2,-1,5,0};
        int[] sort = xiEr.xierSort(nums);
        System.out.println(Arrays.toString(sort));
    }
}
