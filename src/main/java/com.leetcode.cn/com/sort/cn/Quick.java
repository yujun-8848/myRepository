package com.leetcode.cn.com.sort.cn;

import java.util.Arrays;

/**
 * 快速排序（递归）
 */
public class Quick {

    public void quickSort(int[] nums, int left, int right) {

        int l = left;
        int r = right;
        int mid = nums[(left + right) / 2];
        int temp;
        while (l < r) {

            while (nums[l] < mid) {
                l++;
            }
            while (nums[r] > mid) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            if (nums[l] == mid) {
                r--;
            }
            if (nums[r] == mid) {
                l++;
            }
        }
        //不加限制会栈溢出
        if(l == r){
            l++;
            r--;
        }
        if (left < r) {
            quickSort(nums, left, r);
        }
        if (right > l) {
            quickSort(nums, l, right);
        }
    }

    public static void main(String[] args) {
        Quick quick = new Quick();
        int[] nums = {3,1,5,89,4,0,-1,8};
        quick.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        String s = " ";
        if(s.isEmpty()){
            System.out.println("11");
        }
    }
}
