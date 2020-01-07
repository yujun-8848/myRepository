package com.leetcode.cn.com.sort.cn;

import java.util.Arrays;

/**
 * 归并排序（分治）
 */
public class Merge {


    //分
    public void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //左分
            mergeSort(nums, left, mid, temp);
            //右分
            mergeSort(nums, mid + 1, right, temp);
            merge(nums, left, right, temp);
        }
    }

    public void merge(int[] nums, int left, int right, int[] temp) {

        int i = left;
        int mid = (left + right) / 2;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t] = nums[i];
                i++;
                t++;
            } else {
                temp[t] = nums[j];
                j++;
                t++;
            }
        }
        while (i <= mid) {
            temp[t] = nums[i];
            i++;
            t++;
        }

        while (j <= right) {
            temp[t] = nums[j];
            j++;
            t++;
        }

        t = 0;
        int arr = left;
        while (arr <= right) {
            nums[arr] = temp[t];
            arr++;
            t++;
        }

    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] nums = {3,1,5,89,4,0,-1,8};
        int[] temp = new int[nums.length];
        merge.mergeSort(nums,0,nums.length - 1,temp);
        System.out.println(Arrays.toString(nums));
    }
}
